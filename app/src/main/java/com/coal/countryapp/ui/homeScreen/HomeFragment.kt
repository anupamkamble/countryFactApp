package com.coal.countryapp.ui.homeScreen

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.coal.countryapp.R
import com.coal.countryapp.di.component.FragmentComponent
import com.coal.countryapp.ui.baseClasses.BaseFragement
import com.coal.countryapp.utilities.AppLogger
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment: BaseFragement<HomeViewModel>(){

    companion object{
       const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var  homeViewModel: HomeViewModel

    override fun provideResourceId(): Int  = R.layout.home_fragment

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setUpView(view: View) {

        refreshData()
        swipe_to_refresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                refreshData()
            }
        })
    }

    fun refreshData(){
        progress_base.visibility = View.VISIBLE
        viewModel.getFacts()
        viewModel.factLiveData.observe(this, Observer {
            AppLogger.e(TAG,it.toString())
            if(swipe_to_refresh.isRefreshing){
                progress_base.visibility = View.GONE
                swipe_to_refresh.isRefreshing = false
            }

        })
    }
}