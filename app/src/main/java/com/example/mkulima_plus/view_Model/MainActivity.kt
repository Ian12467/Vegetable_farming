package com.example.mkulima_plus.view_Model

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.example.mkulima_plus.Isaka.Isaka_Adapter
import com.example.mkulima_plus.Isaka.IsakaActivity
import com.example.mkulima_plus.Managu.Managu_Activity
import com.example.mkulima_plus.SignIn_activity
import com.example.mkulima_plus.View.cropsAdapater
import com.example.mkulima_plus.View.cropsModel
import com.example.mkulima_plus.kunde.kundeActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(),cropsAdapater.OnlickListener{
    lateinit var Recyclerview: RecyclerView
    lateinit var navcontroller:NavController
    lateinit var images: ArrayList<Int>
    lateinit var textname: Array<String>
    lateinit var dataArray: ArrayList<cropsModel>
    lateinit var dataArray2: ArrayList<Isaka_Adapter>
    lateinit var Auth:FirebaseAuth
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setting up optionMenu Provider
        // initialise Auth
        Auth= FirebaseAuth.getInstance()

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.tool_bar_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return true
            }
        })
        images = arrayListOf(
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2
        )
        textname = arrayOf(
            "Kunde",
            "Managu",
            "Isaka"
        )
        Recyclerview = findViewById(R.id.Recyclerview)
        Recyclerview.layoutManager = GridLayoutManager(this, 3)
        Recyclerview.hasFixedSize()
        dataArray = arrayListOf<cropsModel>()
        val adapter = cropsAdapater(dataArray,this@MainActivity)
        Recyclerview.adapter = adapter
        for (x in images.indices) {
            val cropsModel_Obj = cropsModel(images[x], textname[x])
            dataArray.add(cropsModel_Obj)
        }
    }

    override fun onclick(position: Int) {
       when(position )
       {
           0->
           {
                   startActivity(Intent(this, kundeActivity::class.java))
           }
           1->
           {
               startActivity(Intent(this,Managu_Activity::class.java))
           }
           2->
           {
               startActivity(Intent(this, IsakaActivity::class.java))
           }

           }
       }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // Check if user is logged in
        if (Auth.currentUser != null) {
            // Log out user
            Auth.signOut()
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
            val intent=Intent(this,SignIn_activity::class.java)
            startActivity(intent)
        }
        finish()
    }
    }
