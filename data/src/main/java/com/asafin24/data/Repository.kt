package com.asafin24.data

import com.asafin24.data.RetrofitInstance
import com.asafin24.domain.model.home.PhonesModel
import retrofit2.Response

class Repository {
    suspend fun getExplorer() : Response<PhonesModel> {
        return com.asafin24.data.RetrofitInstance.api.getExplorer()
    }
}