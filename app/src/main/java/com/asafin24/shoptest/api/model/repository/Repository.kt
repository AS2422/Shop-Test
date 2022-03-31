package com.asafin24.shoptest.api.model.repository

import com.asafin24.shoptest.api.RetrofitInstance
import com.asafin24.shoptest.api.model.home.PhonesModel
import retrofit2.Response

class Repository {
    suspend fun getExplorer() : Response<PhonesModel> {
        return RetrofitInstance.api.getExplorer()
    }
}