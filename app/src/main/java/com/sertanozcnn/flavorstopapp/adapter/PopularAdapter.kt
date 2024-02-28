package com.sertanozcnn.flavorstopapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sertanozcnn.flavorstopapp.DetailsActivity
import com.sertanozcnn.flavorstopapp.databinding.PopulerItemBinding

class PopularAdapter(
    private val item: List<String>,
    private val price: List<String>,
    private val image: List<Int>,
    private val requireContext:Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopulerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        if (position < item.size && position < price.size && position < image.size) {
            val items = item[position]
            val prices = price[position]
            val images = image[position]
            holder.bind(items, prices, images)

            holder.itemView.setOnClickListener {
                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", items)
                intent.putExtra("MenuItemImage",images)
                requireContext.startActivity(intent)
            }
        }
    }


    override fun getItemCount(): Int {
        return item.size
    }


    class PopularViewHolder(private val binding: PopulerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageViewPopular
        fun bind(item: String, price: String, image: Int) {
            binding.foodNamePopular.text = item
            binding.pricePopular.text = price
            imagesView.setImageResource(image)
        }
    }
}