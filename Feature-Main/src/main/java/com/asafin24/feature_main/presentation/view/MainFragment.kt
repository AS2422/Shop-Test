package com.asafin24.feature_main.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.asafin24.feature_main.R
import com.asafin24.feature_main.databinding.FragmentMainBinding
import com.asafin24.feature_main.presentation.adapter.CartAdapter
import com.asafin24.feature_main.presentation.viewModel.CartViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import nl.joery.animatedbottombar.AnimatedBottomBar


class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popupMenu = PopupMenu(requireContext(), null)
        popupMenu.inflate(R.menu.bottom_menu)
        val menu = popupMenu.menu

        val bottomNavigationView = view.findViewById<AnimatedBottomBar>(R.id.mainBottomNavigationView)
        navController = (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment)
            .navController
        bottomNavigationView.setupWithNavController(menu, navController)

        //получаем данные о Cart и выводим кол-во добавленных товаров в Badge BottomMenu
        val viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.getCart()
        viewModel.cartList.observe(viewLifecycleOwner) { list ->
            list.body()?.let {
                val cartList = CartAdapter()
                cartList.setList(it.basket)
                bottomNavigationView.setBadgeAtTabId(R.id.cartMenuFragment, AnimatedBottomBar.Badge(cartList.itemCount.toString()))
            }
        }
        //
    }

    override fun onStart() {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.explorerFragment -> showBottomNav()
                R.id.likeFragment -> showBottomNav()
                R.id.userFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
        super.onStart()
    }

    private fun showBottomNav() {
        binding.mainBottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.mainBottomNavigationView.visibility = View.GONE
    }
}