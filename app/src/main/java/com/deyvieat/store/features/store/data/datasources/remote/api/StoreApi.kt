package com.deyvieat.store.features.store.data.datasources.remote.api

import com.deyvieat.store.features.store.data.datasources.remote.models.ProductDto
import retrofit2.http.GET

interface StoreApi {

    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}