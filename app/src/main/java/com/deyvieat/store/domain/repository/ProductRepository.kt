package com.deyvieat.store.domain.repository

import com.deyvieat.store.domain.entity.Product

interface ProductRepository{
    suspend fun getProducts(): List<Product>
}