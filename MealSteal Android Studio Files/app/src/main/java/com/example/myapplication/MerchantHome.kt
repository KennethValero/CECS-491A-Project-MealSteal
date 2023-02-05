package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MerchantHome : AppCompatActivity() {
    private lateinit var btnChat: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchanthome)
        btnChat = findViewById(R.id.btnMerChat)

        btnChat.setOnClickListener()
        {
            startActivity(Intent(this, Register::class.java))
        }
    }
}