package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

//If we are at this activity, then the User (either Merchant or Customer) has already successfully logged in.
class Profile : AppCompatActivity() {
    private lateinit var binding::ActivityProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        var currentUser = FirebaseAuth.getInstance().currentUser


    }
}