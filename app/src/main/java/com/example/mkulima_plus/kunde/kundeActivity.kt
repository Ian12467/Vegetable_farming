package com.example.mkulima_plus.kunde

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mkulima_plus.R
class kundeActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kunde)
        val navHost=supportFragmentManager.findFragmentById(R.id.kundeFragmentHost) as NavHostFragment
        navController=navHost.findNavController()
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.kunde_tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val kundeAttacks: View =findViewById(R.id.kunde_Attacks)
        val kundeTips: View =findViewById(R.id.kunde_Tips)
        val kundeAbout: View =findViewById(R.id.kunde_About)
        when(item.itemId){
            R.id.kunde_Attacks-> {
            navController.navigate(R.id.action_kunde_About_to_kunde_Attacks)
                kundeAttacks .setOnClickListener(null)
                kundeTips.setOnClickListener(null)
                kundeAbout.setOnClickListener(null)
        }
    }
        when(item.itemId){
            R.id.kunde_Tips-> {
            navController.navigate(R.id.action_kunde_About_to_kunde_Tips)
                kundeAttacks .setOnClickListener(null)
              kundeTips.setOnClickListener(null)
                kundeAbout.setOnClickListener(null)
        }
    }
        return false
    }
}