package com.coal.countryapp.di.component

import com.coal.countryapp.CountryApplication
import com.coal.countryapp.di.module.AppModule
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent{

    fun inject(application: CountryApplication)
}