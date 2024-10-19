package com.example.farmereats.fragments

import ApiRepository
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.farmereats.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseApiFragment: Fragment() {
    private lateinit var apiRepository: ApiRepository


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRepository()
    }

    private fun initializeRepository() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://sowlab.com/assignment/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        apiRepository = ApiRepository(apiService)
    }
}