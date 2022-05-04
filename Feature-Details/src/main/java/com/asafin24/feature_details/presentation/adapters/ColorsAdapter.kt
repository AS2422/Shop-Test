package com.asafin24.feature_details.presentation.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.feature_details.R
import com.asafin24.feature_details.databinding.ColorsItemBinding
import com.asafin24.feature_details.domain.model.detail.SelectModel

class ColorsAdapter(val listener: Listener) : RecyclerView.Adapter<ColorsAdapter.ColorsVH>() {

    var colorsData = emptyList<String>()

    var colorsList = mutableListOf(
        SelectModel(isSelected = true),
        SelectModel()
    )

    class ColorsVH(item: View) : RecyclerView.ViewHolder(item) {

        val binding = ColorsItemBinding.bind(item)

        fun bind(color: String, listener: Listener) {
            binding.ivColor.setColorFilter(Color.parseColor(color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.colors_item, parent, false)
        return ColorsVH(view)
    }

    override fun onBindViewHolder(holder: ColorsVH, position: Int) {

        holder.bind(colorsData[position], listener)

        val colors = colorsList[position]

        if (colors.isSelected) listener.onClickColors(holder.itemView)
        else listener.unClickColors(holder.itemView)

        holder.itemView.setOnClickListener {
            for (i in 0 until colorsList.size) {
                colorsList[i].isSelected = false
            }
            colors.isSelected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return colorsData.size
    }

    interface Listener {
        fun onClickColors(color: View)
        fun unClickColors(color: View)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setColorList(list: List<String>) {
        colorsData = list
        notifyDataSetChanged()
    }
}