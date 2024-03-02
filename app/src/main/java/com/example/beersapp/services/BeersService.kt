package com.example.beersapp.services

import com.example.beersapp.core.RetrofitManager
import com.example.beersapp.models.Beer
import com.example.beersapp.services.network.BeersApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeersService {

    private val retrofit = RetrofitManager.getRetrofit()

    suspend fun getBeers (size: Int) : List<Beer> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(BeersApiClient::class.java).getBeers(size)
            response.body() ?: emptyList()
        }
    }
}