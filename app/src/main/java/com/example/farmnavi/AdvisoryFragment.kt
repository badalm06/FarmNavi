package com.example.farmnavi

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class AdvisoryFragment : Fragment(R.layout.fragment_advisory) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Crop Name dropdown
        val cropNames = listOf("Wheat", "Rice", "Maize", "Barley")
        val cropNameDropdown = view.findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_crop_name)
        val cropNameAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, cropNames)
        cropNameDropdown.setAdapter(cropNameAdapter)

        // Setup Growth Stage dropdown
        val growthStages = listOf("Seedling", "Vegetative", "Flowering", "Maturity")
        val growthStageDropdown = view.findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_growth_stage)
        val growthStageAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, growthStages)
        growthStageDropdown.setAdapter(growthStageAdapter)

        // Setup Season dropdown
        val seasons = listOf("Winter", "Summer", "Monsoon", "Spring")
        val seasonDropdown = view.findViewById<MaterialAutoCompleteTextView>(R.id.dropdown_season)
        val seasonAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, seasons)
        seasonDropdown.setAdapter(seasonAdapter)

        // Setup toolbar back button
        val toolbar = view.findViewById<MaterialToolbar>(R.id.topAppBar)
        toolbar?.apply {
            setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
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
