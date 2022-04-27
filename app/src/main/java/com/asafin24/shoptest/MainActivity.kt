package com.asafin24.shoptest

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavigatorProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.asafin24.shoptest.databinding.ActivityMainBinding
import com.asafin24.utils.navigation.NavCommand
import com.asafin24.utils.navigation.NavCommands
import com.asafin24.utils.navigation.NavigationProvider


class MainActivity : AppCompatActivity() {

    private val navController: NavController
        get() = findNavController(R.id.containerView)

    lateinit var binding: ActivityMainBinding
//    lateinit var navController: NavController
//    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        APP = this
//
//        //navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as? NavHostFragment ?: return
//        navController = findNavController(R.id.mainNavHostFragment)
//        val popupMenu = PopupMenu(this, null)
//        popupMenu.inflate(R.menu.bottom_menu)
//        val menu = popupMenu.menu
//
//        binding.mainBottomNavView.setupWithNavController(menu, navController)

        //APP.navController.navigate(R.id.action_explorerFragment_to_explorerActivity3)
    }


}