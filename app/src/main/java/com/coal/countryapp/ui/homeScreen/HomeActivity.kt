package com.coal.countryapp.ui.homeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coal.countryapp.R
import com.coal.countryapp.di.component.ActivityComponent
import com.coal.countryapp.ui.baseClasses.BaseActivity
import kotlinx.android.synthetic.main.home_actitvity_layout.*

class HomeActivity : BaseActivity() {


    override fun getResourceLayoutId(): Int = R.layout.home_actitvity_layout

    override fun injectDependency(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setUpView(savedInstanceState: Bundle?) {

        val fragment = HomeFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment,HomeFragment.TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
