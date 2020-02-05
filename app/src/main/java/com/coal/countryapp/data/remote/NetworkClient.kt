package com.coal.countryapp.data.remote

import com.coal.countryapp.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object NetworkClient {

    private const val TIMEOUT = 60

    fun create(baseUrl : String,cache: File,cacheSize: Long):NetWorkService{
       return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .cache(okhttp3.Cache(cache,cacheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    })
                    .readTimeout(TIMEOUT.toLong(),TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT.toLong(),TimeUnit.SECONDS)
                    .build())

            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetWorkService::class.java)
    }


}