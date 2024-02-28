package com.sertanozcnn.flavorstopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sertanozcnn.flavorstopapp.databinding.ActivitySplashScreenBinding
import com.sertanozcnn.flavorstopapp.databinding.BuyAgainItemBinding

class BuyAgainAdapter(
    private val buyAgainFoodName: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyAgainImage: ArrayList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(
            buyAgainFoodName[position],
            buyAgainFoodPrice[position],
            buyAgainImage[position]
        )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding =
            BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }


    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.buyAgainFoodName.text = foodName
            binding.buyAgainFoodPrice.text = foodPrice
            binding.buyAgainFoodImage.setImageResource(foodImage)
        }

    }

    override fun getItemCount(): Int = buyAgainFoodName.size


}