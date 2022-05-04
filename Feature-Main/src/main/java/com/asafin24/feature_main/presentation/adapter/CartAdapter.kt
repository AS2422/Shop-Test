package com.asafin24.feature_main.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.feature_main.R
import com.asafin24.feature_main.domain.model.home.Basket
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartVH>() {

    var products = emptyList<Basket>()
    var numbers = mutableListOf<Int>()

    class CartVH(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartVH =
        CartVH(LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false))

    override fun onBindViewHolder(holder: CartVH, position: Int): Unit = holder.itemView.run {

        holder.itemView.tv_price_product.text = "$" + products[position].price.toString() + ".00"
        holder.itemView.tv_name_product.text = products[position].title
        Glide.with(this).load(products[position].images).into(iv_cart_products)

        numbers.add(position, holder.itemView.number_products.text.toString().toInt())

        holder.itemView.add_product.setOnClickListener {
            if (numbers[position] >= 0) {
                numbers[position]++
                holder.itemView.number_products.text = numbers[position].toString()
            }
            notifyDataSetChanged()
        }

        holder.itemView.remove_product.setOnClickListener {
            if (numbers[position] > 0) {
                numbers[position]--
                holder.itemView.number_products.text = numbers[position].toString()
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Basket>) {
        products = list
        notifyDataSetChanged()
    }
}