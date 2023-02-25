package com.example.mastermach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class UserLoginComponent : Fragment() {
    private lateinit var role: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        role = requireArguments().getString("role").toString()
        return inflater.inflate(R.layout.fragment_user_login_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signUpBtn: TextView = view.findViewById(R.id.signUpBtn)

        signUpBtn.setOnClickListener {
            val signupComponent = UserSignupComponent()
            val args = Bundle()
            args.putString("role", role)
            signupComponent.arguments = args

            val fragmentManager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.mainLoginFrameLayout, signupComponent)
            fragmentTransaction.commit()
            when (role){
                "user" -> activity?.title = "User SignUp"
                "admin" -> activity?.title = "Admin SignUp"
            }
        }

    }
}
