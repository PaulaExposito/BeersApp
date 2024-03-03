package com.example.beersapp.di

import com.example.beersapp.services.network.dao.BeersApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit (): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiClient (retrofit: Retrofit) : BeersApiClient =
        retrofit.create(BeersApiClient::class.java)
}