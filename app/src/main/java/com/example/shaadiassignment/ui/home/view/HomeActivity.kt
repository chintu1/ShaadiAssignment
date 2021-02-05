package com.example.shaadiassignment.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaadiassignment.databinding.ActivityHomeBinding
import com.example.shaadiassignment.ui.home.`interface`.UserActionClickListener
import com.example.shaadiassignment.ui.home.adapter.UserDetailsAdapter
import com.example.shaadiassignment.ui.home.viewmodel.HomeViewModel
import com.example.shaadiassignment.util.DataState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import java.io.IOException

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    val homeViewModel by viewModels<HomeViewModel>()
    lateinit var homeActivityHomeBinding: ActivityHomeBinding
    lateinit var userDetailsAdapter: UserDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityHomeBinding.root)
        setUpRecyclerView()
        setUpAllObserver()
    }

    private fun setUpRecyclerView() {
        setUserRecyclerViewLayoutManager()
        setUserRecyclerViewAdapter()
    }

    private fun setUpAllObserver() {
        homeViewModel.userDetails.observe(this, Observer {
            when (it) {
                is DataState.Success -> {
                    hideLoadingProgressBar()
                    userDetailsAdapter.setData(it.data)
                }
                is DataState.Loading -> {
                    showLoadingProgressBar()
                }
                is DataState.Error -> {
                    hideLoadingProgressBar()
                }
            }
        })
    }

    private fun setUserRecyclerViewLayoutManager() {
        homeActivityHomeBinding.userDetailRecyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun setUserRecyclerViewAdapter() {
        userDetailsAdapter = UserDetailsAdapter(object : UserActionClickListener {
            override fun onAcceptButtonClick() {
                showMessage("Member Accepted")
            }

            override fun onIgnoreButtonClick() {
                showMessage("Member Declined")
            }

        })
        homeActivityHomeBinding.userDetailRecyclerview.adapter = userDetailsAdapter
    }

    private fun hideLoadingProgressBar() {
        homeActivityHomeBinding.homeContentLoadingProgressbar.hide()
    }

    private fun showLoadingProgressBar() {
        homeActivityHomeBinding.homeContentLoadingProgressbar.show()
    }

    fun showMessage(msg:String){
        Snackbar.make(homeActivityHomeBinding.root,msg,Snackbar.LENGTH_SHORT).show()
    }
}