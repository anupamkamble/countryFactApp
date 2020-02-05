package com.coal.countryapp

import android.app.Application
import com.coal.countryapp.di.component.AppComponent
import com.coal.countryapp.di.component.DaggerAppComponent
import com.coal.countryapp.di.module.AppModule

class CountryApplication : Application(){

    lateinit var applicationComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
        injectDependency()
    }

    fun injectDependency(){
        applicationComponent =  DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        applicationComponent.inject(this)
    }

}