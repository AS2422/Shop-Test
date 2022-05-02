package com.asafin24.feature_details.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.feature_details.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.details_carousel_item.view.*
import kotlinx.android.synthetic.main.details_images_item.view.*

class CarouselDetailsAdapter : RecyclerView.Adapter<CarouselDetailsVH>() {

    private var imagesList = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselDetailsVH =
        CarouselDetailsVH(LayoutInflater.from(parent.context).inflate(R.layout.details_carousel_item, parent, false))

    override fun getItemCount(): Int = imagesList.size

    override fun onBindViewHolder(holder: CarouselDetailsVH, position: Int): Unit = holder.itemView.run {

        Glide.with(this).load(imagesList[position]).into(image_carousel_item)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<String>) {
        imagesList = list
        notifyDataSetChanged()
    }
}

class CarouselDetailsVH(itemView: View) : RecyclerView.ViewHolder(itemView)