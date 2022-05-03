package com.asafin24.feature_main.domain.model.home

import java.io.Serializable

data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
) : Serializable