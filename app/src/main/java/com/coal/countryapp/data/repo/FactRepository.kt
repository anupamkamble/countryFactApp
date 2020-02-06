package com.coal.countryapp.data.repo

import com.coal.countryapp.data.remote.APIResponse.FactResponse
import com.coal.countryapp.data.remote.NetWorkService
import com.coal.countryapp.utilities.NetworkConnectivity
import io.reactivex.Observable
import javax.inject.Inject

class FactRepository @Inject constructor(val netWorkService: NetWorkService,val  networkConnectivity: NetworkConnectivity){


    fun getFacts(): Observable<FactResponse> {
        if (networkConnectivity.isNetworkConnected()){
           return netWorkService.getFacts()
        }
        return Observable.just(null)
    }
}