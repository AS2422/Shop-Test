package com.asafin24.shoptest.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.shoptest.R
import com.asafin24.domain.model.home.HomeStore
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.hot_sales_item.view.*
import kotlinx.android.synthetic.main.hot_sales_item.view.iv_product
import kotlinx.android.synthetic.main.product_item.view.*

class CarouselAdapter : RecyclerView.Adapter<CarouselVH>() {

    private var hotSaleslList = emptyList<HomeStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselVH =
        CarouselVH(LayoutInflater.from(parent.context).inflate(R.layout.hot_sales_item, parent, false))

    override fun getItemCount(): Int = hotSaleslList.size

    override fun onBindViewHolder(holder: CarouselVH, position: Int): Unit = holder.itemView.run {
        holder.itemView.brandname.text = hotSaleslList[position].title
        holder.itemView.description_product.text = hotSaleslList[position].subtitle
        Glide.with(this).load(hotSaleslList[position].picture).into(iv_product)

        if (hotSaleslList[position].is_new) holder.itemView.tagNew.visibility = View.VISIBLE
        else holder.itemView.tagNew.visibility = View.INVISIBLE
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<HomeStore>) {
        hotSaleslList = list
        notifyDataSetChanged()
    }
}

class CarouselVH(itemView: View) : RecyclerView.ViewHolder(itemView)