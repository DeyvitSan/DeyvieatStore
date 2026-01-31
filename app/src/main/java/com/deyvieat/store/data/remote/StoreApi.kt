package com.deyvieat.store.data.remote

import com.deyvieat.store.data.remote.dto.ProductDto
import retrofit2.http.GET

interface StoreApi{
    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}