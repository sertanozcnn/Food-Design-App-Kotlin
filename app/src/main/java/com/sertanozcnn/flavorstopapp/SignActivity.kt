package com.sertanozcnn.flavorstopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sertanozcnn.flavorstopapp.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {

    private val binding:ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.alReadyButton.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signButton.setOnClickListener {
            val intent = Intent(this,ChooseLocationActivity::class.java)
            startActivity(intent)
        }

    }
}