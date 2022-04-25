package com.asafin24.feature_explorer.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.asafin24.feature_explorer.APPexplorer
import com.asafin24.feature_explorer.R
import com.asafin24.feature_explorer.databinding.ActivityExplorerBinding

class ExplorerActivity : AppCompatActivity() {

    lateinit var binding: ActivityExplorerBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityExplorerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APPexplorer = this

        navController = findNavController(R.id.mainNavHostFragment)

    }

}