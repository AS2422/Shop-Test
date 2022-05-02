package com.asafin24.feature_details.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.feature_details.R
import com.asafin24.feature_details.databinding.DetailsMenuItemBinding
import com.asafin24.feature_details.domain.model.detail.SelectModel

class DetailsMenuAdapter(val listener: Listener) : RecyclerView.Adapter<DetailsMenuAdapter.ViewHolder>() {

    var menuList = mutableListOf(
        SelectModel("Shop", true),
        SelectModel("Details"),
        SelectModel("Features")
    )


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = DetailsMenuItemBinding.bind(item)

        fun bind(menu: SelectModel, listener: Listener) {
            binding.tvDetailsCategory.text = menu.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_menu_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(menuList[position], listener)

        val category = menuList[position]

        if (category.isSelected) listener.onClickDetailsMenu(holder.itemView)
        else listener.unClickDetailsMenu(holder.itemView)

        holder.itemView.setOnClickListener {
            for (i in 0 until menuList.size) {
                menuList[i].isSelected = false
            }
            category.isSelected = true
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    interface Listener {
        fun onClickDetailsMenu(menu: View)
        fun unClickDetailsMenu(menu: View)
    }

}