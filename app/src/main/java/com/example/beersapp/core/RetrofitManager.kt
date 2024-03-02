package com.example.beersapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    fun getRetrofit () : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}