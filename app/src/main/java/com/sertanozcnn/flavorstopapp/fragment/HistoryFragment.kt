package com.sertanozcnn.flavorstopapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sertanozcnn.flavorstopapp.R
import com.sertanozcnn.flavorstopapp.adapter.BuyAgainAdapter
import com.sertanozcnn.flavorstopapp.databinding.FragmentHistoryBinding
import com.sertanozcnn.flavorstopapp.databinding.FragmentHomeBinding


class HistoryFragment : Fragment() {

    private lateinit var binding:FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val buyAgainFoodName = arrayListOf("Food 1","Food 2","Food 3")
        val buyAgainFoodPrice = arrayListOf("10 ₺","20 ₺","30 ₺")
        val buyAgainFoodImage = arrayListOf(R.drawable.popularimage3,R.drawable.popularimage2,R.drawable.popularimage1)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


}