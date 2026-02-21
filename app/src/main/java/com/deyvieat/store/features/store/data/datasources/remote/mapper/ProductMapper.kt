package com.deyvieat.store.features.store.data.datasources.remote.mapper

import com.deyvieat.store.features.store.data.datasources.remote.models.ProductDto
import com.deyvieat.store.features.store.domain.entities.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        category = this.category,
        image = this.image
    )
}