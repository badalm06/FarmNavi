package com.example.farmnavi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MarketFragment : Fragment(R.layout.fragment_market) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar?.apply {
            // Set navigation icon (back arrow)
            setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)

            // Handle back button click to pop back stack
            setNavigationOnClickListener {
                if(requireActivity().supportFragmentManager.backStackEntryCount > 0) {
                    requireActivity().supportFragmentManager.popBackStack()
                } else {
                    // Optional fallback to default back press if stack empty
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }

        // Add any other UI setup or event listeners here
        // Example:
        // view.findViewById<Button>(R.id.some_button)?.setOnClickListener { ... }
    }
}
