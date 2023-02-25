package com.example.mastermach

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class SplashScreenLogin : Fragment() {

    lateinit var userImg: ImageView
    lateinit var adminImg: ImageView
    lateinit var staffImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userImg = view.findViewById(R.id.userImg)
        adminImg = view.findViewById(R.id.adminImg)
        staffImg = view.findViewById(R.id.staffImg)

        userImg.setOnClickListener {
            mainActivityFun("user")
        }
        adminImg.setOnClickListener {
            mainActivityFun("admin")
        }

        staffImg.setOnClickListener {
            mainActivityFun("staff")
        }

    }

    private fun mainActivityFun (role: String){
        val intent = Intent (activity, MainActivity::class.java)
        intent.putExtra("role", role)
        activity?.startActivity(intent)
    }
}