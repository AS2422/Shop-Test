package com.asafin24.shoptest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.shoptest.R
import com.asafin24.shoptest.databinding.ProductItemBinding
import com.asafin24.shoptest.model.CategoryModel
import com.asafin24.shoptest.model.ProductModel
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductVH>() {

    val products = ArrayList<ProductModel>()

    class ProductVH(item: View) : RecyclerView.ViewHolder(item) {

        val binding = ProductItemBinding.bind(item)

        fun bind(product: ProductModel) {
            binding.priceProduct.text = "$ ${product.price}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH =
        ProductVH(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductVH, position: Int) = holder.itemView.run {
        holder.bind(products[position])

        price_product.text = "$ ${products[position].price}"
    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addProduct(productAddList: ProductModel) {
        products.add(productAddList)
        notifyDataSetChanged()
    }
}