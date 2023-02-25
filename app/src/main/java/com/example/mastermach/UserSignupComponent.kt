package com.example.mastermach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class UserSignupComponent : Fragment() {
    lateinit var role: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        role = requireArguments().getString("role").toString()
        return inflater.inflate(R.layout.fragment_user_signup_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backBtn: Button = view.findViewById((R.id.backBtn))
        println(role)
        backBtn.setOnClickListener {
            val loginComponent = UserLoginComponent()
            val args = Bundle()
            args.putString("role", role)
            loginComponent.arguments = args

            val fragmentManager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.mainLoginFrameLayout, loginComponent)
            fragmentTransaction.commit()
        }
    }
}