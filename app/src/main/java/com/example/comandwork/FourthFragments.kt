package com.example.comandwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fourth.*

import kotlinx.android.synthetic.main.fragment_third.*

class FourthFragments : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultThirdWorld.text = arguments?.getString("FourthWorld")

        backButtons.setOnClickListener { fragmentManager?.popBackStack()  }
        thirdButtonOK.setOnClickListener {
            val forurthWorld = thirdInput.text.toString()
            val fragmentFourth = FourthFragments()
            fragmentFourth.arguments = Bundle().also {
                it.putString("World", forurthWorld)
            }
                //git
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragmentFourth)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}