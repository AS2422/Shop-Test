package com.asafin24.feature_main.presentation.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.asafin24.feature_main.R
import com.asafin24.feature_main.databinding.FragmentCartMenuBinding
import com.asafin24.feature_main.presentation.adapter.CartAdapter
import com.asafin24.feature_main.presentation.viewModel.CartViewModel


class CartMenuFragment : Fragment(R.layout.fragment_cart_menu) {

    lateinit var binding: FragmentCartMenuBinding
    private val cartAdapter = CartAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartMenuBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        binding.rvCart.adapter = cartAdapter

        val viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.getCart()
        viewModel.cartList.observe(viewLifecycleOwner) { list ->
            list.body()?.let {
                cartAdapter.setList(it.basket)

                binding.tvDeliveryValue.text = it.delivery

                binding.tvTotalValue.text = "$" + it.total.toString() + " us"
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(Uri.parse("jetnavapp://main"))
        }
    }
}