package com.sertanozcnn.flavorstopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sertanozcnn.flavorstopapp.adapter.NotificationAdapter
import com.sertanozcnn.flavorstopapp.databinding.ActivityMainBinding
import com.sertanozcnn.flavorstopapp.fragment.NotificationBottomFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog = NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

        val navController = findNavController(R.id.fragmentContainerView)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setupWithNavController(navController)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            navController.popBackStack()

            val currentFragment = navController.currentDestination?.id

            if (currentFragment != R.id.cartFragment) {
                navController.navigate(R.id.cartFragment)
            }
        }


    }
}