package com.coal.countryapp.di.module

import android.app.Application
import com.coal.countryapp.CountryApplication
import com.coal.countryapp.data.remote.EndPoints
import com.coal.countryapp.data.remote.NetWorkService
import com.coal.countryapp.data.remote.NetworkClient
import dagger.Module
import dagger.Provides

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule(var application : CountryApplication) {

    @Singleton
    @Provides
    fun provideNetWorkService() : NetWorkService =
        NetworkClient.create(EndPoints.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024
        )

    @Singleton
    @Provides
    fun provideCompositeDeposible() : CompositeDisposable = CompositeDisposable()

    @Singleton
    @Provides
    fun provideApplication(): Application = application

}