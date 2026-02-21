package com.deyvieat.store.features.store.domain.repositories

import com.deyvieat.store.features.store.domain.entities.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}
