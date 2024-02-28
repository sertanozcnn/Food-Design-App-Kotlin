package com.sertanozcnn.flavorstopapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.sertanozcnn.flavorstopapp.R
import com.sertanozcnn.flavorstopapp.adapter.MenuAdapter
import com.sertanozcnn.flavorstopapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter:MenuAdapter
    private val originalMenuFoodName = listOf(
        "Burger",
        "Sandwich",
        "Momo",
        "Item",
        "Sandwich",
        "Latte",
    )
    private val originalMenuItemPrice = listOf("10 ₺" , "20 ₺","30 ₺","100 ₺")
    private val originalMenuImage = listOf(R.drawable.popularimage1,R.drawable.popularimage2,R.drawable.popularimage3,R.drawable.popularimage1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName ,filteredMenuItemPrice ,filteredMenuImage ,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setupSearchView()
        showAllMenu()



        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }


    private fun setupSearchView() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })

    }
    private fun filterMenuItems(query: String?) {
        if (query.isNullOrEmpty()) {
            showAllMenu()
            return
        }

        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                if (index < originalMenuItemPrice.size) { // Buradaki düzeltmeyi kontrol edin
                    filteredMenuItemPrice.add(originalMenuItemPrice[index])
                }
                if (index < originalMenuImage.size) {
                    filteredMenuImage.add(originalMenuImage[index])
                }
            }
        }
        adapter.notifyDataSetChanged()
    }



}