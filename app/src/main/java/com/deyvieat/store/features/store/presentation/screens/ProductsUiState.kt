package com.deyvieat.store.features.store.presentation.screens

import com.deyvieat.store.features.store.domain.entities.Product


data class ProductsUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)