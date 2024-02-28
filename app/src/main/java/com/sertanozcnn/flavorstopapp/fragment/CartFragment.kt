package com.sertanozcnn.flavorstopapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sertanozcnn.flavorstopapp.ActivityPayOut
import com.sertanozcnn.flavorstopapp.R
import com.sertanozcnn.flavorstopapp.adapter.CartAdapter
import com.sertanozcnn.flavorstopapp.databinding.FragmentCartBinding
import com.sertanozcnn.flavorstopapp.databinding.FragmentHomeBinding


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Burger", "Sandwich", "Momo")
        val cartItemPrice = listOf("10 ₺", "20 ₺", "30 ₺")
        val cartImage =
            listOf(R.drawable.popularimage1, R.drawable.popularimage2, R.drawable.popularimage3)

        val adapter =
            CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        binding.proccedButton.setOnClickListener {
            val intent = Intent(requireContext(),ActivityPayOut::class.java)
            startActivity(intent)
        }

        binding.proccedButton.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }


        return binding.root
    }


}