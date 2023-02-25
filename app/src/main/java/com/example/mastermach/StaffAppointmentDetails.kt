package com.example.mastermach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

class StaffAppointmentDetails : Fragment() {
    lateinit var textView: TextView
    var id: String? = null

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
        id = requireArguments().getString("id")
        return inflater.inflate(R.layout.fragment_staff_appointment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        staffNameTextView = view.findViewById(R.id.staffAppointmentClientName)
        staffEmailTextView = view.findViewById(R.id.staffAppointmentClientEmail)
        staffCompanyTextView = view.findViewById(R.id.staffAppointmentClientCompany)
        staffRoleTextView = view.findViewById(R.id.staffAppointmentClientRole)

        phoneNumberEditText = view.findViewById(R.id.staffAppointmentRentDetailsPhoneNumber)
        addressLineEditText = view.findViewById(R.id.staffAppointmentRentDetailsAddressLine)
        cityEditText = view.findViewById(R.id.staffAppointmentRentDetailsCity)
        stateEditText = view.findViewById(R.id.staffAppointmentRentDetailsState)
        pincodeEditText = view.findViewById(R.id.staffAppointmentRentDetailsPincode)

        staffNameTextView.text = (staffName + this.id)
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