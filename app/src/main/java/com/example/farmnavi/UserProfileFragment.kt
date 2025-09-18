package com.example.farmnavi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar?.apply {
            // Set back navigation icon
            setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)

            // Handle back button click to pop the fragment stack
            setNavigationOnClickListener {
                if (requireActivity().supportFragmentManager.backStackEntryCount > 0) {
                    requireActivity().supportFragmentManager.popBackStack()
                } else {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}