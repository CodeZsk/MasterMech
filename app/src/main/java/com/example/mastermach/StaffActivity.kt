package com.example.mastermach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class StaffActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)

        val drawerLayout: DrawerLayout = findViewById(R.id.staffDrawerLayout)
        val navView: NavigationView = findViewById(R.id.staffNavigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_staff_Profile -> Toast.makeText(applicationContext, "Profile", Toast.LENGTH_LONG).show()
                R.id.nav_staff_dashboard -> Toast.makeText(applicationContext, "Dashboard", Toast.LENGTH_LONG).show()
                R.id.nav_staff_rent -> Toast.makeText(applicationContext, "Rent", Toast.LENGTH_LONG).show()
                R.id.nav_staff_activity -> Toast.makeText(applicationContext, "Activity", Toast.LENGTH_LONG).show()
                R.id.nav_staff_logout -> Toast.makeText(applicationContext, "Logout", Toast.LENGTH_LONG).show()
            }

            true

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}