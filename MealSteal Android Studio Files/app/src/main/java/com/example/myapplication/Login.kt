package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //accessing our textview from layout
        val registertext = findViewById<TextView>(R.id.newAccount) as TextView
        registertext.setOnClickListener()
        {
            startActivity(Intent(this, Register::class.java))
        }
    }

}