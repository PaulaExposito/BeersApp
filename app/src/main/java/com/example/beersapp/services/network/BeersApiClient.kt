package com.example.beersapp.services.network

import com.example.beersapp.models.Beer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeersApiClient {
    @GET("beers")
    suspend fun getBeers (@Query("size") size: Int) : Response<List<Beer>>
}