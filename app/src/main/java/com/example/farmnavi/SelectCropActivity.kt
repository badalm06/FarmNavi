package com.example.farmnavi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class SelectCropActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_crop)

        // Crop Name dropdown items
        val cropNames = listOf("Wheat", "Rice", "Maize", "Barley")
        val cropNameAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cropNames)
        (findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_crop_name)).setAdapter(cropNameAdapter)

        // Growth Stage dropdown items
        val growthStages = listOf("Seedling", "Vegetative", "Flowering", "Maturity")
        val growthStageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, growthStages)
        (findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_growth_stage)).setAdapter(growthStageAdapter)

        // Season dropdown items
        val seasons = listOf("Winter", "Summer", "Monsoon", "Spring")
        val seasonAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, seasons)
        (findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_season)).setAdapter(seasonAdapter)

        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Correct way for modern Android
        }

        // Bottom navigation item selection listener (if needed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.selectedItemId = R.id.nav_advisory

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, Home_Screen::class.java))
                    true
                }
                R.id.nav_advisory -> {
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
