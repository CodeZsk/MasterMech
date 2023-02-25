package com.example.mastermach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager

        val bundle = intent.extras
        val role = bundle?.get("role")

        when(role){
            "user" -> replaceFragment(UserLoginComponent(), "User Login", role as String)
            "admin" -> replaceFragment(UserLoginComponent(), "Admin Login", role as String)
            "staff" -> replaceFragment(StaffLogin(), "Staff Login", role as String)
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String, role: String) {
        val args = Bundle()
        args.putString("role", role)
        fragment.arguments = args

        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainLoginFrameLayout, fragment)
        fragmentTransaction.commit()
        setTitle(title)
    }


}