package com.deyvieat.store.di

import com.deyvieat.store.data.remote.StoreApi
import com.deyvieat.store.data.repository.ProductRepositoryImpl
import com.deyvieat.store.domain.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val baseUrl = "https://fakestoreapi.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: StoreApi by lazy {
        retrofit.create(StoreApi::class.java)
    }

    val productRepository: ProductRepository by lazy{
        ProductRepositoryImpl(retrofitService)
    }
}