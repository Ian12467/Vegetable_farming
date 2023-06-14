package com.example.mkulima_plus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mkulima_plus.view_Model.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SignIn_activity : AppCompatActivity() {
    private lateinit var Auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val email=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password=findViewById<EditText>(R.id.editTextTextPassword)
        val siginButton=findViewById<Button>(R.id.signInButton)
        val sigup=findViewById<TextView>(R.id.textview_sigin)
        //Initialise Auth
        Auth=FirebaseAuth.getInstance()
        sigup.setOnClickListener {
            val intent=Intent(this,Sign_Up_Activity::class.java)
            startActivity(intent)
        }
        siginButton.setOnClickListener {
            val Email=email.text.toString()
            val Password=password.text.toString()

            if(Email.isNotEmpty() && Password.isNotEmpty())
            {
                 Auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
    override fun onStart() {
        super.onStart()
        val currentUser =  Auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
