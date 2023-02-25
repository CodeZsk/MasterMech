package com.example.mastermach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class StaffRentComponent {
    var view: View

    constructor(layoutInflater: LayoutInflater, linearLayout: LinearLayout,textViewArr: Array<TextView?>,
                fragmentManager: FragmentManager?, num: Int){
        view = layoutInflater.inflate(R.layout.sub_view, null)

        var textView: TextView = view.findViewById(R.id.subTextView)
        textViewArr.set(num, textView)
        textView.text = num.toString()

        textView.setOnClickListener {
            val staffAppointmentDetails = StaffAppointmentDetails()
            val args = Bundle()
            args.putString("id", num.toString())
            staffAppointmentDetails.arguments = args

            val fragmentManager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.staffFrameLayout, staffAppointmentDetails)
            fragmentTransaction.commit()
        }

        linearLayout.addView(view)
    }
}