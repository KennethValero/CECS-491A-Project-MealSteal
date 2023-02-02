package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Register : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding
    private lateinit var editName: EditText
    private lateinit var user_type: String
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        editName = findViewById(R.id.username)

        val account_type = resources.getStringArray(R.array.account_type_array)
        val spinner = findViewById<Spinner>(R.id.account_type_spinner)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, account_type)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                Toast.makeText(applicationContext, account_type[position], Toast.LENGTH_SHORT).show()
                user_type = account_type[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
        binding.btnRegister.setOnClickListener()
        {
            Toast.makeText(this, "Check if worked" , Toast.LENGTH_SHORT).show()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val name = editName.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty())
            {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener()
                {
                    if (it.isSuccessful)
                    {
                        addUserToDB(name, email, password, firebaseAuth.uid.toString(), user_type)
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

    private fun addUserToDB(name: String, email: String, password: String, uid: String, user_type: String) {
        database = FirebaseDatabase.getInstance().getReference()
        database.child("user").child(uid).setValue(User(name,email, password, uid, user_type))
    }
}

