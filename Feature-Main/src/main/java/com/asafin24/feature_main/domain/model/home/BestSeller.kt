package com.asafin24.feature_main.domain.model.home

import java.io.Serializable

data class BestSeller(
    val discount_price: Int,
    val id: Int,
    var is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
) : Serializable