package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding
    private lateinit var editUser: EditText
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        val spinner: Spinner = findViewById(R.id.account_type_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.account_type_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        binding.btnRegister.setOnClickListener()
        {
            Toast.makeText(this, "Check if worked" , Toast.LENGTH_SHORT).show()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty())
            {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener()
                {
                    if (it.isSuccessful)
                    {
                        Toast.makeText(this, "Check if worked" , Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this , it.exception.toString() , Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this, "Error, Invalid Input" , Toast.LENGTH_SHORT).show()
            }
        }
    }


}

