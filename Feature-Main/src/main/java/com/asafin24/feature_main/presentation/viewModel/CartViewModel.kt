package com.asafin24.feature_main.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asafin24.feature_main.data.Repository
import com.asafin24.feature_main.domain.model.home.CartModel
import kotlinx.coroutines.launch
import retrofit2.Response

class CartViewModel : ViewModel() {

    val repository = Repository()
    val cartList: MutableLiveData<Response<CartModel>> = MutableLiveData()

    fun getCart() {
        viewModelScope.launch {
            cartList.value = repository.getCart()
        }
    }
}