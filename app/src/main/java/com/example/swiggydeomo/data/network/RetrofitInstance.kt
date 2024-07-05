package com.example.swiggydeomo.data.network

import com.example.swiggydeomo.util.AppConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val retrofitInstance: Retrofit = Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    val apiService : ApiService = retrofitInstance.create(ApiService::class.java)

}