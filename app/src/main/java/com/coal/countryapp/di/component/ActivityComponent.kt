package com.coal.countryapp.di.component

import com.coal.countryapp.di.ActivityScope
import com.coal.countryapp.di.module.ActivityModule
import com.coal.countryapp.ui.homeScreen.HomeActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class],dependencies = [AppComponent::class])
interface ActivityComponent {

    fun  inject(activity:HomeActivity)

}