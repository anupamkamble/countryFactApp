package com.coal.countryapp.di.component

import com.coal.countryapp.CountryApplication
import com.coal.countryapp.data.remote.NetWorkService
import com.coal.countryapp.data.repo.FactRepository
import com.coal.countryapp.di.module.AppModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{

    fun inject(application: CountryApplication)

    fun getNetworkService(): NetWorkService
    fun getFactRepo() : FactRepository
    fun getCompositeDespo() : CompositeDisposable
}