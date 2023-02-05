package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomerHome : AppCompatActivity() {
    private lateinit var btnChat: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customerhome)

        btnChat = findViewById(R.id.btnCustChat)

        btnChat.setOnClickListener()
        {
            startActivity(Intent(this, Register::class.java))
        }
    }
}