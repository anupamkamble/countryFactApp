package com.coal.countryapp.ui.baseClasses

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.coal.countryapp.CountryApplication
import com.coal.countryapp.di.component.ActivityComponent
import com.coal.countryapp.di.component.DaggerActivityComponent
import com.coal.countryapp.di.module.ActivityModule
import javax.inject.Inject


abstract class BaseActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependency(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayoutId())
        setUpView(savedInstanceState)

    }

    fun buildActivityComponent() = DaggerActivityComponent.builder()
        .appComponent((application as CountryApplication).applicationComponent)
        .activityModule(ActivityModule(this))
        .build()

    fun goBack() = onBackPressed()

    override fun onBackPressed() {
        super.onBackPressed()
    }

    @LayoutRes
    protected abstract fun  getResourceLayoutId(): Int

    protected abstract fun injectDependency(activityComponent: ActivityComponent)

    protected abstract fun setUpView(savedInstanceState: Bundle?)

}