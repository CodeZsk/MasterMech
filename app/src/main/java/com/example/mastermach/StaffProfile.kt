package com.example.mastermach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


class StaffProfile : Fragment() {
//    Profile Header
    lateinit var staffName: String
    lateinit var email: String
    lateinit var company: String
    lateinit var role: String

//    Profile Address
    lateinit var phoneNumber: String
    lateinit var addressLine: String
    lateinit var city: String
    lateinit var state: String
    lateinit var pincode: String

//    View elements
    lateinit var staffNameTextView: TextView
    lateinit var staffEmailTextView: TextView
    lateinit var staffCompanyTextView: TextView
    lateinit var staffRoleTextView: TextView

    lateinit var phoneNumberEditText: EditText
    lateinit var addressLineEditText: EditText
    lateinit var cityEditText: EditText
    lateinit var stateEditText: EditText
    lateinit var pincodeEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        staffName = "Zaid"
        email = "zaid.shaikh.17660@ves.ac.in"
        company = "vesasc"
        role = "Oparater"
        phoneNumber = "9372575921"
        addressLine = "29/A/408, Mahada Colony, Shivaji Nagar"
        city = "Mumbai"
        state = "Maharastra"
        pincode = "400043"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        staffNameTextView = view.findViewById(R.id.staffProfileName)
        staffEmailTextView = view.findViewById(R.id.staffProfileEmail)
        staffCompanyTextView = view.findViewById(R.id.staffProfileCompany)
        staffRoleTextView = view.findViewById(R.id.staffProfileRole)

        phoneNumberEditText = view.findViewById(R.id.staffProfilePhoneNumber)
        addressLineEditText = view.findViewById(R.id.staffProfileAddressLine)
        cityEditText = view.findViewById(R.id.staffProfileCity)
        stateEditText = view.findViewById(R.id.staffProfileState)
        pincodeEditText = view.findViewById(R.id.staffProfilePincode)

        staffNameTextView.text = staffName
        staffEmailTextView.text = email
        staffCompanyTextView.text = company
        staffRoleTextView.text = role
        phoneNumberEditText.hint = phoneNumber
        addressLineEditText.hint = addressLine
        cityEditText.hint = city
        stateEditText.hint = state
        pincodeEditText.hint = pincode
    }

}