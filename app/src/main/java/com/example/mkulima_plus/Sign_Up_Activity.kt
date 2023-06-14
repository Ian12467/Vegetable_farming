package com.example.mkulima_plus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Sign_Up_Activity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val email=findViewById<EditText>(R.id.editTextTextEmailAddress_signup)
        val password=findViewById<EditText>(R.id.editTextTextPassword_signup)
        val siginButton=findViewById<Button>(R.id.signupButton)
        firebaseAuth=FirebaseAuth.getInstance()
        siginButton.setOnClickListener {
            val Email = email.text.toString()
            val Password = password.text.toString()
            if (Email.isNotEmpty() && Password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, SignIn_activity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }
