package com.asafin24.feature_details.domain.repository

import com.asafin24.feature_details.domain.model.detail.DetailModel
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getExplorer() : DetailModel

}