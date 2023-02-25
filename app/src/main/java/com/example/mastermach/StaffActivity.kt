package com.example.mastermach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class StaffActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)

        drawerLayout = findViewById(R.id.staffDrawerLayout)
        val navView: NavigationView = findViewById(R.id.staffNavigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fragmentManager = supportFragmentManager

        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.staffFrameLayout, StaffDashboard())
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.nav_staff_Profile -> replaceFragment(StaffProfile(), it.title.toString())
                R.id.nav_staff_dashboard -> replaceFragment(StaffDashboard(), it.title.toString())
                R.id.nav_staff_rent -> replaceFragment(StaffRent(), it.title.toString())
                R.id.nav_staff_activity -> replaceFragment(StaffRentHistory(), it.title.toString())
                R.id.nav_staff_logout -> {
                    val intent = Intent(this, SplashScreen::class.java)
                    // start your next activity
                    intent.putExtra("logout", true)
                    finish();
                    startActivity(intent)
                }
            }

            true

        }
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.staffFrameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}