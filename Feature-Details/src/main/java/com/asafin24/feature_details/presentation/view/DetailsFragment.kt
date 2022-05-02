package com.asafin24.feature_details.presentation.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.asafin24.feature_details.R
import com.asafin24.feature_details.databinding.FragmentDetailsBinding
import com.asafin24.feature_details.presentation.adapters.CarouselDetailsAdapter
import com.asafin24.feature_details.presentation.adapters.ColorsAdapter
import com.asafin24.feature_details.presentation.adapters.DetailsMenuAdapter
import com.asafin24.feature_details.presentation.viewModel.DetailsViewModel
import kotlinx.android.synthetic.main.colors_item.view.*
import kotlinx.android.synthetic.main.details_menu_item.view.*
import kotlin.math.abs


class DetailsFragment : Fragment(), ColorsAdapter.Listener, DetailsMenuAdapter.Listener {

    lateinit var binding: FragmentDetailsBinding
    private val carouselDetailsAdapter = CarouselDetailsAdapter()
    private var colorsAdapter = ColorsAdapter(this)
    private var detailsMenuAdapter = DetailsMenuAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    fun init() {

        getData()

        //carousel
        binding.carouselImages.adapter = carouselDetailsAdapter
        binding.carouselImages.clipToPadding = false
        binding.carouselImages.clipChildren = false
        binding.carouselImages.offscreenPageLimit = 3
        binding.carouselImages.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f
        }

        binding.carouselImages.setPageTransformer(compositePageTransformer)
        //

        binding.recyclerViewColors.adapter = colorsAdapter
        binding.recyclerViewDetailsMenu.adapter = detailsMenuAdapter

    }

    private fun getData() {
        val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        val ratingList = mutableListOf(
            binding.rating1,
            binding.rating2,
            binding.rating3,
            binding.rating4,
            binding.rating5
        )

        viewModel.getDetails()

        viewModel.dataDetails.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                binding.tvTitleProduct.text = data.title
                binding.tvCpu.text = data.CPU
                binding.tvCamera.text = data.camera
                binding.tvOzu.text = data.ssd
                binding.tvPzu.text = data.sd
                binding.capacity1.text = data.capacity[0] + " GB"
                binding.capacity2.text = data.capacity[1] + " GB"
                binding.tvPrice.text = "$" + data.price.toString()

                carouselDetailsAdapter.setList(it.images)
                colorsAdapter.setColorList(it.color)

                if (data.isFavorites) binding.btnLike.setImageResource(R.drawable.ic_like)
                else binding.btnLike.setImageResource(R.drawable.ic_unlike)

                var chekedFavorites = data.isFavorites
                binding.btnLike.setOnClickListener {
                    chekedFavorites = !chekedFavorites

                    if (chekedFavorites) binding.btnLike.setImageResource(R.drawable.ic_like)
                    else binding.btnLike.setImageResource(R.drawable.ic_unlike)
                }

                for (i in 0..data.rating.toInt()) ratingList[i].visibility = View.VISIBLE
            }
        })


    }

    override fun onClickColors(color: View) {
        color.iconSelected.visibility = View.VISIBLE
    }

    override fun unClickColors(color: View) {
        color.iconSelected.visibility = View.INVISIBLE
    }

    override fun onClickDetailsMenu(menu: View) {
        menu.line.visibility = View.VISIBLE
        menu.tv_details_category.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
    }

    override fun unClickDetailsMenu(menu: View) {
        menu.line.visibility = View.INVISIBLE
        menu.tv_details_category.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnBack.setOnClickListener {
            findNavController().navigate(Uri.parse("jetnavapp://main"))
        }

    }

}