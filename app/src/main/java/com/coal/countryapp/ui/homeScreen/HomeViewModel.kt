package com.coal.countryapp.ui.homeScreen
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coal.countryapp.data.remote.APIResponse.FactItem
import com.coal.countryapp.data.remote.NetWorkService
import com.coal.countryapp.data.repo.FactRepository
import com.coal.countryapp.utilities.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    val repo: FactRepository,
    val netWorkService: NetWorkService,
    val compositeDisposable: CompositeDisposable
) : ViewModel(){

     var factLiveData = MutableLiveData<List<FactItem?>>()
     var stateLiveData = MutableLiveData<Resource<Any>>()

    fun onCreated(){}

    fun getFacts(){
        stateLiveData.postValue(Resource.loading())
        compositeDisposable.add(
            repo.getFacts()
                .subscribeOn(Schedulers.io())
                .doOnNext { Resource.loading(it) }
                .doOnError { stateLiveData.postValue(Resource.error("Error occured while fetchin data")) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { factLiveData.postValue(it.rows) }
        )
        stateLiveData.postValue(Resource.success())
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
            compositeDisposable.dispose()
        }
    }
}