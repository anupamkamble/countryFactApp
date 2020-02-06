package com.coal.countryapp.ui.baseClasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.coal.countryapp.CountryApplication
import com.coal.countryapp.di.component.DaggerFragmentComponent
import com.coal.countryapp.di.component.FragmentComponent
import com.coal.countryapp.di.module.FragmentModule
import com.coal.countryapp.ui.homeScreen.HomeViewModel
import javax.inject.Inject

abstract class BaseFragement<VM: ViewModel>: Fragment(){


    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildDependency())
        super.onCreate(savedInstanceState)
        (viewModel as HomeViewModel).onCreated()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideResourceId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    fun buildDependency() =
        DaggerFragmentComponent.builder()
            .appComponent((context!!.applicationContext as CountryApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()


    fun goBack() {
        if (activity is BaseActivity) (activity as BaseActivity).goBack()
    }

    @LayoutRes
    abstract fun provideResourceId() : Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    abstract fun setUpView(view : View)
}