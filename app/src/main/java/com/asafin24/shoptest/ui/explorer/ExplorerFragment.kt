package com.asafin24.shoptest.ui.explorer

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.asafin24.shoptest.R
import com.asafin24.shoptest.adapter.CarouselAdapter
import com.asafin24.shoptest.adapter.CategoryAdapter
import com.asafin24.shoptest.adapter.ProductAdapter
import com.asafin24.shoptest.databinding.FragmentExplorerBinding
import com.asafin24.shoptest.model.ProductModel
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.fragment_explorer.*
import java.lang.Exception


class ExplorerFragment : Fragment(), CategoryAdapter.Listener {

    lateinit var binding: FragmentExplorerBinding
    private val adapterCategory = CategoryAdapter(this)
    private val productCategory = ProductAdapter()
    private var city: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExplorerBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        popupMenu(fragment_explorer)
    }

    fun init() {
        binding.recyclerViewCategory.adapter = adapterCategory

        binding.carousel.adapter = CarouselAdapter()

        binding.apply {
            rvProducts.layoutManager = GridLayoutManager(context, 2)
            rvProducts.adapter = productCategory
            productCategory.addProduct(ProductModel(228))
            productCategory.addProduct(ProductModel(3232))
            productCategory.addProduct(ProductModel(4338))
            productCategory.addProduct(ProductModel(4565))
        }

        filter()
    }

    override fun onClickCategory(category: View) {
        category.name_category.setTextColor(ContextCompat.getColor(requireContext(),R.color.orange))
        category.iconCategoryShape.setBackgroundResource(R.drawable.shape_orange)
        category.iconCategory.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
    }

    override fun unClickCategory(category: View) {
        category.name_category.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        category.iconCategoryShape.setBackgroundResource(R.drawable.shape_white)
        category.iconCategory.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
    }

    private fun popupMenu(view: View) {

        val popupMenu = androidx.appcompat.widget.PopupMenu(view.context,btn_select_city)
        popupMenu.inflate(R.menu.cities_menu)
        popupMenu.setOnMenuItemClickListener {
            city = it.toString()
            btn_select_city.text = city
            true
        }

        binding.btnSelectCity.setOnClickListener {
            try {
                val popup = androidx.appcompat.widget.PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true

                val menu = popup.get(popupMenu)
                menu.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu,true)

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                popupMenu.show()
            }
        }
    }

    private fun filter() {
        binding.ibFilter.setOnClickListener {
            binding.filterScreen.visibility = View.VISIBLE
        }

        binding.btnCloseFilter.setOnClickListener {
            binding.filterScreen.visibility = View.GONE
        }
    }
}