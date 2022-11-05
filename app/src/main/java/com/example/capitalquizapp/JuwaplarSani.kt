package com.example.capitalquizapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class JuwaplarSani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juwaplar_sani)



        val juwapp=findViewById<TextView>(R.id.juwaplar_sani)
        val juwap =intent.getStringExtra("My_juwap")

        juwapp.text=juwap


    }
}