package com.example.beersapp.services

import com.example.beersapp.models.Beer
import com.example.beersapp.services.network.dao.BeersService
import com.example.beersapp.services.network.dto.toBeer
import javax.inject.Inject

class BeersRepository @Inject constructor (private val api: BeersService) {
    suspend fun getBeers (size: Int) : List<Beer> {
        val response = api.getBeers(size)
        return response.map { it.toBeer() }
    }
}