package com.deyvieat.store.features.store.data.repositories

import android.util.Log
import com.deyvieat.store.features.store.data.datasources.remote.api.StoreApi
import com.deyvieat.store.features.store.data.datasources.remote.mapper.toDomain
import com.deyvieat.store.features.store.domain.entities.Product
import com.deyvieat.store.features.store.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: StoreApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        Log.d("FakeStoreAPI", response.toString())
        return response.map { it.toDomain() }
    }
}