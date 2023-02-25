package com.example.mastermach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.fragment.app.FragmentManager

class SplashScreen : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    lateinit var splashScreenFrameLayout : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val bundle = intent.extras
        var logout = bundle?.getBoolean("logout")

        if (logout == true) {
            splashScreenReplace()
        }else{
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    splashScreenReplace()
                },
                3000 // value in milliseconds
            )
        }

    }

    private fun splashScreenReplace() {
        splashScreenFrameLayout = findViewById(R.id.splashScreenFrameLayout)
        splashScreenFrameLayout.removeAllViews()
        fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.splashScreenFrameLayout, SplashScreenLogin())
        fragmentTransaction.commit()
    }
}