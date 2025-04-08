package com.multiplying_numbers.presentation

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ActivityMainBinding
import com.multiplying_numbers.domain.TypeTable
import com.multiplying_numbers.presentation.fragments.StartedFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivity1"

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
        selectedItemDrawListener()

    }

    private fun selectedItemDrawListener() {
        binding.navigationView.setNavigationItemSelectedListener { menu ->
            var isHandled = true
            //______________________________________________________________________________________
            when (menu.itemId) {
                R.id.item_multiple -> openFragmentListTab(typeTable = TypeTable.MULTIPLE)
                R.id.item_division -> openFragmentListTab(typeTable = TypeTable.DIVISION)
                R.id.item_addition -> openFragmentListTab(typeTable = TypeTable.ADDITION)
                R.id.item_subtraction -> openFragmentListTab(typeTable = TypeTable.SUBTRACTION)
                R.id.item_with_brackets -> openFragmentListTab(typeTable = TypeTable.WITH_BRACKETS)
                else -> isHandled = false

            }
            //close menu____________________________________________________________________________
            if (isHandled) drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener isHandled
        }
    }


    private fun setTitleAppBar() {
        navController.addOnDestinationChangedListener { nav, destination, bundle ->
            when (destination.id) {
                R.id.startedFragment -> setTitleFromStringResurge(idString = R.string.check_self)

                R.id.listTablesFragment -> setTitleFromStringResurge(idString = R.string.select_table)

                R.id.singleTabFragment -> setTitleFromStringResurge(idString = R.string.choose_answer)

                R.id.fragmentHistory -> setTitleFromStringResurge(idString = R.string.history)
            }
        }

    }


    private fun initDrawMenu() {
        navController = findNavController(R.id.main_container)
        drawerLayout = binding.mainDrawerLayout
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(android.R.color.white)))
        setupActionBarWithNavController(navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /** otherFun _________________________________________________________________________________*/
    //selectedItemDrawListener
    private fun openFragmentListTab(typeTable: TypeTable) {
        val action =
            StartedFragmentDirections.actionStartedFragmentToListFragment(typeTable = typeTable)
        navController.navigate(action)
    }

    //setTitleAppBar
    private fun setTitleFromStringResurge(idString: Int) {
        supportActionBar?.title = getString(idString)
    }
}