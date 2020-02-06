package com.coal.countryapp.di.component

import com.coal.countryapp.di.FragmentScope
import com.coal.countryapp.di.module.FragmentModule
import com.coal.countryapp.ui.homeScreen.HomeFragment
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [AppComponent::class])
interface FragmentComponent {
    fun inject(fragment: HomeFragment)
}