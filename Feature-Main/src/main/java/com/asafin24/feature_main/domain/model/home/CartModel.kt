package com.asafin24.feature_main.domain.model.home

data class CartModel(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)