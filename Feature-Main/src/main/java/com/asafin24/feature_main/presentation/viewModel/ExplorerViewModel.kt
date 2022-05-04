package com.asafin24.feature_main.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asafin24.feature_main.data.Repository
import com.asafin24.feature_main.domain.model.home.PhonesModel
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