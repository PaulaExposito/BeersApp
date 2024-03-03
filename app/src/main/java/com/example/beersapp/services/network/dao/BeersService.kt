package com.example.beersapp.services.network.dao

import com.example.beersapp.services.network.dto.BeerApiDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeersService @Inject constructor (private val api: BeersApiClient) {
    suspend fun getBeers (size: Int) : List<BeerApiDTO> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getBeers(size)
                response.body() ?: emptyList()
            }
            catch (ex: Exception) {
                emptyList()
            }
        }
    }
}