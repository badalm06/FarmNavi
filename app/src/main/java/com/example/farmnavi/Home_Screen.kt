package com.example.farmnavi

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Quick Access Crop Advisory click
        findViewById<LinearLayout>(R.id.item_crop).setOnClickListener {
            startActivity(Intent(this, SelectCropActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.item_market).setOnClickListener {
            startActivity(Intent(this, MarketPricesActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.item_pest).setOnClickListener {
            startActivity(Intent(this, PestDiseaseAnalysisActivity::class.java))
        }


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Set Advisory tab selected by default if you are in advisory screen:
        // If this is Home, set nav_home selected
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already on Home screen, do nothing
                    true
                }
                R.id.nav_advisory -> {
                    startActivity(Intent(this, SelectCropActivity::class.java))
                    true
                }
                R.id.nav_market -> {
                    startActivity(Intent(this, MarketPricesActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, UserProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
