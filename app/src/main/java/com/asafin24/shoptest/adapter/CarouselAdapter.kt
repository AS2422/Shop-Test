package com.asafin24.shoptest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.shoptest.R
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.hot_sales_item.view.*

class CarouselAdapter : RecyclerView.Adapter<CarouselVH>() {

    private val brandnameList = arrayListOf<String>(
        "Iphone 12",
        "Xiaomi Mi 10",
        "Samsung Galaxy 20",
        "Motorolla"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselVH =
        CarouselVH(LayoutInflater.from(parent.context).inflate(R.layout.hot_sales_item, parent, false))

    override fun getItemCount(): Int = brandnameList.size

    override fun onBindViewHolder(holder: CarouselVH, position: Int) = holder.itemView.run {
        brandname.text = brandnameList[position]
        //container.setBackgroundResource(colors[position])
    }
}

class CarouselVH(itemView: View) : RecyclerView.ViewHolder(itemView)