package com.asafin24.data.api

import com.asafin24.domain.model.home.PhonesModel
import retrofit2.Response

class Repository {
    suspend fun getExplorer() : Response<PhonesModel> {
        return RetrofitInstance.api.getExplorer()
    }
}