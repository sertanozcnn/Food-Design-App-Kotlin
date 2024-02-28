package com.sertanozcnn.flavorstopapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sertanozcnn.flavorstopapp.DetailsActivity
import com.sertanozcnn.flavorstopapp.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemPrices: MutableList<String>,
    private val menuImages: MutableList<Int>,
    private val requireContext: Context
) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)

    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }

                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItemsName.get(position))
                intent.putExtra("MenuItemImage", menuImages.get(position))
                requireContext.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            if (position < menuItemsName.size && position < menuItemPrices.size && position < menuImages.size) {
                binding.apply {
                    menuFoodName.text = menuItemsName[position]
                    menuPrice.text = menuItemPrices[position]
                    menuImage.setImageResource(menuImages[position])


                }
            }
        }
    }

    interface OnClickListener {

        fun onItemClick(position: Int) {

        }


    }
}


