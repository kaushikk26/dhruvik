package com.example.tictactoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Startpage : AppCompatActivity() {

    lateinit var play: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startpage)

         play = findViewById(R.id.startbtn)
        play.setOnClickListener {

            val intent = Intent(this, Game_page::class.java)
            startActivity(intent)
        }

    }
}