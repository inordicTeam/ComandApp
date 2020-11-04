package com.example.comandwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fisrt.*
import kotlinx.android.synthetic.main.fragment_fisrt.view.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewFirstWord.text = arguments?.getString("word")

        backButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        secondButton.setOnClickListener() {
            val secondWord = secondInput.text.toString()

            val fragmentSecond = ThirdFragment()
            fragmentSecond.arguments = Bundle().also {
                it.putString("secondWord", secondWord)
            }

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragmentSecond)
                ?.addToBackStack(null)
                ?.commit()

        }

    }

}