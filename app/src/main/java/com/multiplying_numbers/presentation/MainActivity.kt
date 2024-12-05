package com.multiplying_numbers.presentation

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
        initDrawMenu()
        setTitleAppBar()

    }

    private fun setTitleAppBar() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.startedFragment -> setTitleFromStringResurge(idString = R.string.check_self)

                R.id.listTablesFragment -> setTitleFromStringResurge(idString = R.string.select_table)

                R.id.singleTabFragment -> setTitleFromStringResurge(idString = R.string.hoose_answer)

                R.id.fragmentHistory -> setTitleFromStringResurge(idString = R.string.history)
            }
        }

    }


    private fun initDrawMenu() {
        navController = findNavController(R.id.main_container)
        drawerLayout = binding.mainDrawerLayout
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        binding.navigationView.setupWithNavController(navController)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(android.R.color.white)))
        setupActionBarWithNavController(navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /** otherFun _________________________________________________________________________________*/
    private fun setTitleFromStringResurge(idString: Int) {
        supportActionBar?.title = getString(idString)
    }
}