package com.asafin24.shoptest.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asafin24.domain.model.home.PhonesModel
import com.asafin24.data.api.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ExplorerViewModel: ViewModel() {

    val repository = Repository()
    val explorerList: MutableLiveData<Response<PhonesModel>> = MutableLiveData()

    fun getExplorer() {
        viewModelScope.launch {
            explorerList.value = repository.getExplorer()
        }
    }

}