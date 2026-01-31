package com.deyvieat.store.data.mapper

import com.deyvieat.store.data.remote.dto.ProductDto
import com.deyvieat.store.domain.entity.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        image = this.image,
        category = this.category
    )
}