package com.sertanozcnn.flavorstopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sertanozcnn.flavorstopapp.databinding.ActivityPayOutBinding
import com.sertanozcnn.flavorstopapp.databinding.FragmentCongratsBottomSheetBinding
import com.sertanozcnn.flavorstopapp.fragment.CongratsBottomSheet

class ActivityPayOut : AppCompatActivity() {

    private lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeMyOrder.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

    }
}