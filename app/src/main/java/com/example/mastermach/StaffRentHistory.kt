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

class StaffRentHistory : Fragment() {
    lateinit var linearLayout: LinearLayout
    lateinit var inflater: LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflater = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_rent_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var fragment: FragmentManager? = fragmentManager
        var textViewArr=Array<TextView?>(10){null}

        linearLayout = view.findViewById(R.id.staffRentHistoryLinearLayout)

        var i = 0
        while (i < 10 ) {
            StaffRentComponent(inflater,linearLayout,textViewArr,fragment, i)
            i += 1
        }
    }
}