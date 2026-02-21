package com.deyvieat.store.features.store.data.datasources.remote.models

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDto? = null
)

data class RatingDto(
    val rate: Double,
    val count: Int
)