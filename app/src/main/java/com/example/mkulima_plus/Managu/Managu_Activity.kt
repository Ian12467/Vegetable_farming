package com.example.mkulima_plus.Managu
import android.content.Intent
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
class Managu_Activity : AppCompatActivity() {
    private lateinit var navcontroller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_managu)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.managu_toolbar)
        setSupportActionBar(toolbar)
        title = "Managu"
        val navhost = supportFragmentManager.findFragmentById(R.id.fragmentContainerViewmanagu) as NavHostFragment
        navcontroller = navhost.findNavController()
        toolbar.setupWithNavController(navcontroller)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.managu_tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val managu_attacks:View=findViewById(R.id.managu_attacks)
        val managu_tiips:View=findViewById(R.id.managu_Tips)
        val managu_abouut:View=findViewById(R.id.managu_about)
        when(item.itemId) {
            R.id.managu_attacks-> {
                navcontroller.navigate(R.id.action_managu_about_to_managu_attacks)
                managu_tiips.setOnClickListener(null)
                managu_attacks.setOnClickListener(null)
                managu_abouut.setOnClickListener(null)
            }
        }
        when (item.itemId) {
            R.id.managu_Tips-> {
                navcontroller.navigate(R.id.action_managu_about_to_managu_Tips)
                managu_tiips.setOnClickListener(null)
                managu_attacks.setOnClickListener(null)
                managu_abouut.setOnClickListener(null)
            }
        }
        when(item.itemId) {
            R.id.fragment_about -> {
                val intent = Intent(this, managu_about::class.java)
                startActivity(intent)
                managu_tiips.setOnClickListener(null)
                managu_attacks.setOnClickListener(null)
                managu_abouut.setOnClickListener(null)
            }
        }
        return false
    }
}
