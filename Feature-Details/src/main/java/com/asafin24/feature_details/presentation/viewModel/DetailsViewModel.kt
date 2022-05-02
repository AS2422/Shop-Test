package com.asafin24.feature_details.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asafin24.feature_details.data.Repository
import com.asafin24.feature_details.domain.model.detail.DetailModel
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel: ViewModel() {

    val repository = Repository()
    val dataDetails = MutableLiveData<DetailModel>()

    fun getDetails() {
        viewModelScope.launch {
            dataDetails.value = repository.getDetails()
        }
    }

}