package com.deyvieat.store.data.repository

import com.deyvieat.store.data.mapper.toDomain
import com.deyvieat.store.data.remote.StoreApi
import com.deyvieat.store.domain.entity.Product
import com.deyvieat.store.domain.repository.ProductRepository

class ProductRepositoryImpl(private val api: StoreApi): ProductRepository{
    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        return response.map { it.toDomain() }
    }
}