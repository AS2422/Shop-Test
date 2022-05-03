package com.asafin24.feature_main.domain.repository

import com.asafin24.feature_main.domain.model.home.CartModel
import com.asafin24.feature_main.domain.model.home.PhonesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getExplorer() : Response<PhonesModel>

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart() : Response<CartModel>

//    @GET("detail")
//    suspend fun getDetail() : Response<>

}