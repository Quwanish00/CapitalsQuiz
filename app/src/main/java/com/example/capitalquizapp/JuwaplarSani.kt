package com.example.capitalquizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class JuwaplarSani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juwaplar_sani)


        val juwapp=findViewById<TextView>(R.id.juwaplar_sani)


      val juwap=intent.getStringExtra("My_juwap").toString()


            juwapp.text= juwap

        val exit=findViewById<Button>(R.id.exit)

        exit.setOnClickListener {
        finish()

        }
        val newGame=findViewById<Button>(R.id.new_game)
        newGame.setOnClickListener {
            val intent=Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

    }
}