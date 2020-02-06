package com.coal.countryapp.ui.homeScreen

import android.view.View
import com.coal.countryapp.R
import com.coal.countryapp.di.component.FragmentComponent
import com.coal.countryapp.ui.baseClasses.BaseFragement
import javax.inject.Inject

class HomeFragment : BaseFragement<HomeViewModel>(){


    @Inject
    lateinit var  homeViewModel: HomeViewModel

    override fun provideResourceId(): Int  = R.layout.home_fragment

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setUpView(view: View) {

    }
}