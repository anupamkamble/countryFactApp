package com.coal.countryapp.data.remote

import com.coal.countryapp.data.remote.APIResponse.FactResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NetWorkService {
    @GET(EndPoints.GET_FACT)
    fun getFacts(): Single<FactResponse>
}