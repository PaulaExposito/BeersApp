package com.example.beersapp.services.network.dao

import com.example.beersapp.services.network.dto.BeerApiDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeersApiClient {
    @GET("beers")
    suspend fun getBeers (@Query("size") size: Int) : Response<List<BeerApiDTO>>
}