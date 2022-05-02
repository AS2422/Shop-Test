package com.asafin24.feature_details.data

import com.asafin24.feature_details.domain.model.detail.DetailModel
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.Response

class Repository {
    suspend fun getDetails() : DetailModel {
        return RetrofitInstance.api.getExplorer()
    }
}