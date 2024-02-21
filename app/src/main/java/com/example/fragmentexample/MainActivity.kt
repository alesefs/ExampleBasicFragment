package com.example.fragmentexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
//import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentexample.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val toolbar: Toolbar = binding.toolbar2
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "rayo"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground)
        toolbar.setNavigationOnClickListener {
            fun onClick(v: View?) {
                onBackPressed()
            }
        }*/

        val toolbar2: Toolbar = binding.toolbar2
        supportActionBar?.show()
        setSupportActionBar(toolbar2)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        toolbar2.setNavigationOnClickListener {
            onBackStackChanged()
        }
        // showing the back button in action bar


//        val toolbar: Toolbar = binding.toolbar
//        supportActionBar?.hide()
//        setActionBar(toolbar)
//        actionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//        }
//        toolbar.setNavigationOnClickListener {
//            Toast.makeText(
//                this,
//                "back pressed",
//                Toast.LENGTH_SHORT
//            ).show()
//            onBackPressed()
//        }


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_eletric
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun onBackStackChanged() {
        Toast.makeText(
            this,
            "back pressed",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}