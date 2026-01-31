package com.deyvieat.store.data.remote.dto

import android.media.Rating
import android.os.Debug
import androidx.compose.ui.FrameRateCategory

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