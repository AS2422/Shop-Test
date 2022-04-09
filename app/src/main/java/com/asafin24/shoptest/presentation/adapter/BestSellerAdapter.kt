package com.asafin24.shoptest.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.shoptest.R
import com.asafin24.domain.model.home.BestSeller
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.product_item.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.ProductVH>() {

    private var products = emptyList<BestSeller>()

    class ProductVH(item: View) : RecyclerView.ViewHolder(item)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH =
        ProductVH(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductVH, position: Int): Unit = holder.itemView.run {

        holder.itemView.price_product.text = "$ ${products[position].discount_price}"
        holder.itemView.old_price_product.text = "$ ${products[position].price_without_discount}"
        holder.itemView.name_product.text = products[position].title
        Glide.with(this).load(products[position].picture).into(iv_product)

        if (products[position].is_favorites) holder.itemView.likeStatus.setBackgroundResource(R.drawable.ic_like)
        else holder.itemView.likeStatus.setBackgroundResource(R.drawable.ic_unlike)

        holder.itemView.tagLike.setOnClickListener {
            products[position].is_favorites = !products[position].is_favorites

            if (products[position].is_favorites) holder.itemView.likeStatus.setBackgroundResource(R.drawable.ic_like)
            else holder.itemView.likeStatus.setBackgroundResource(R.drawable.ic_unlike)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<BestSeller>) {
        products = list
        notifyDataSetChanged()
    }

}