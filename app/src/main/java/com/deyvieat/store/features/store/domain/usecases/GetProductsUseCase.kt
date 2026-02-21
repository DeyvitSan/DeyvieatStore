package com.deyvieat.store.features.store.domain.usecases

import com.deyvieat.store.features.store.domain.entities.Product
import com.deyvieat.store.features.store.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<Product>> {
        return try {
            val products = repository.getProducts()
            val filtered = products.filter { it.title.isNotBlank() }

            if (filtered.isEmpty()) {
                Result.failure(Exception("No se encontraron productos válidos"))
            } else {
                Result.success(filtered)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
