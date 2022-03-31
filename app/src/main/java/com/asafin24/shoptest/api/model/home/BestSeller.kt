package com.asafin24.shoptest.api.model.home

data class BestSeller(
    val discount_price: Int,
    val id: Int,
    var is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
)