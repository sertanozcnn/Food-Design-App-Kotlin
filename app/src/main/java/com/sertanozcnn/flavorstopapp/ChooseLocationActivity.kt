package com.sertanozcnn.flavorstopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.sertanozcnn.flavorstopapp.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


         val locationList = arrayOf("İstanbul", "İzmir", "Ankara")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

        if (autoCompleteTextView.adapter != null && autoCompleteTextView.adapter.count > 0) {
            Log.d("ChooseLocationActivity", "Veriler başarıyla eklendi.")
        } else {
            Log.d("ChooseLocationActivity", "Veri eklenirken bir sorun oluştu.")
        }
    }




}
