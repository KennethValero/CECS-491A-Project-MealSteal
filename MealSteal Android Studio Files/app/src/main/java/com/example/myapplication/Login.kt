package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity(){

    private lateinit var editEmail: EditText
    private lateinit var editPass: EditText
    private lateinit var btnLog: Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        editEmail = findViewById(R.id.email)
        editPass = findViewById(R.id.password)

        //accessing our textview from layout
        val registertext = findViewById<TextView>(R.id.newAccount) as TextView
        registertext.setOnClickListener()
        {
            startActivity(Intent(this, Register::class.java))
        }

        btnLog.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPass.text.toString()

            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = firebaseAuth.currentUser
                        user?.let {
                            val name = user.displayName
                            val email = user.email
                            val account_type =
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

}