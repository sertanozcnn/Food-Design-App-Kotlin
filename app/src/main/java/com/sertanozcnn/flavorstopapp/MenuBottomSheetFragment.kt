package com.sertanozcnn.flavorstopapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sertanozcnn.flavorstopapp.adapter.MenuAdapter
import com.sertanozcnn.flavorstopapp.databinding.FragmentCartBinding
import com.sertanozcnn.flavorstopapp.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Burger", "Sandwich", "Momo", "Burger")
        val menuItemPrice = listOf("10 ₺", "20 ₺", "30 ₺", "100 ₺")
        val menuImage = listOf(
            R.drawable.popularimage1,
            R.drawable.popularimage2,
            R.drawable.popularimage3,
            R.drawable.popularimage1
        )

        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage),
            requireContext()
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}