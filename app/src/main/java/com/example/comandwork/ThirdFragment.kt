package com.example.comandwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultSecondWorld.text = arguments?.getString("secondWord")

        backButtons.setOnClickListener { fragmentManager?.popBackStack()  }
        thirdButtonOK.setOnClickListener {
            val thirdWorld = thirdInput.text.toString()
            val fragmentThird = FourthFragments()
            fragmentThird.arguments = Bundle().also {
                it.putString("ThirdWorld", thirdWorld )
            }

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragmentThird)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}
