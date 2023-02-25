package com.example.mastermach

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class StaffDashboard : Fragment() {

    lateinit var dashboardAppointementLinerLayout: LinearLayout
    lateinit var appContext: Context
//    lateinit var fragmentManager: FragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_dashboard, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val callHistoryTextView : TextView = view.findViewById(R.id.callHistory)
        callHistoryTextView.setOnClickListener {
            println("Helllo worodlkd")
            val fragmentManager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.staffFrameLayout, StaffRentHistory())
            fragmentTransaction.commit()
            activity?.setTitle("Rent History")
        }
        super.onViewCreated(view, savedInstanceState)
        dashboardAppointementLinerLayout = view.findViewById(R.id.staffDashboardAppointment)
        createAppointment(appContext, dashboardAppointementLinerLayout)
        createAppointment(appContext, dashboardAppointementLinerLayout)
        createAppointment(appContext, dashboardAppointementLinerLayout)


    }

    fun createAppointment(context: Context, linearLayout: LinearLayout){
        val textView = TextView(context)
        textView.text = "Your New Appointment"
        textView.width = linearLayout.width
        textView.textSize = 20F
        linearLayout.addView(textView)
    }

}