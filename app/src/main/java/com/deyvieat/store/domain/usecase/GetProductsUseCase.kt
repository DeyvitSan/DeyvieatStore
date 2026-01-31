package com.deyvieat.store.domain.usecase

import com.deyvieat.store.domain.entity.Product
import com.deyvieat.store.domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository){
    suspend operator fun invoke(): List<Product>{
        return repository.getProducts()
    }
}