package com.coal.countryapp.di.module

import androidx.lifecycle.ViewModelProviders
import com.coal.countryapp.data.remote.NetWorkService
import com.coal.countryapp.data.repo.FactRepository
import com.coal.countryapp.ui.baseClasses.BaseFragement
import com.coal.countryapp.ui.homeScreen.HomeViewModel
import com.coal.countryapp.utilities.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class FragmentModule( val fragment: BaseFragement<*>) {

    @Provides
    fun  provideHomeViewModel(
        compositeDisposable: CompositeDisposable,
        netWorkService: NetWorkService,
        repo: FactRepository
    ): HomeViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(HomeViewModel::class){
            HomeViewModel(repo, netWorkService, compositeDisposable) }).get(HomeViewModel::class.java)




}