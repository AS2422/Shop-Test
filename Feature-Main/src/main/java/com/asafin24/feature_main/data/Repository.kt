package com.asafin24.feature_main.data

import com.asafin24.feature_main.domain.model.home.PhonesModel
import retrofit2.Response

class Repository {
    suspend fun getExplorer() : Response<PhonesModel> {
        return RetrofitInstance.api.getExplorer()
    }
}