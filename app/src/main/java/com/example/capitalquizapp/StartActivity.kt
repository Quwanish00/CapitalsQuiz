package com.example.capitalquizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.capitalquizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding:ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferens:SharedPreferences=getSharedPreferences("CapitalSettings",Context.MODE_PRIVATE)

        binding.etName.addTextChangedListener {
            binding.tilName.isErrorEnabled=false
            binding.btnStart.isEnabled=true
        }

        binding.btnStart.setOnClickListener {
            binding.btnStart.isEnabled=true

            val name = binding.etName.text.toString()

            if(name.isEmpty() || name.isBlank()){
                binding.tilName.error=getString(R.string.error_majburiy)

                binding.btnStart.isEnabled=false
            }
            else{

                sharedPreferens.edit().putString("username",name).apply()
                val intent=Intent(this,GameActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}