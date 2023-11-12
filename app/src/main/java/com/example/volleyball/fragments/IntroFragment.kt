package com.example.volleyball.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentIntroBinding

class IntroFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentIntroBinding
    var introInterface: onIntroFragmentButtonsClick? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is onIntroFragmentButtonsClick) {
            introInterface = context
        } else {
            throw Exception("Activity must implement onIntroFragmentButtonsClick")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentIntroBinding.inflate(inflater)

        binding.btnLogin.setOnClickListener(this)
        binding.btnAbout.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(view: View) {
        when(view.id){
            binding.btnLogin.id -> introInterface?.lauchLogin()
            binding.btnAbout.id -> introInterface?.lauchAbout()
        }
    }

    interface onIntroFragmentButtonsClick {
        fun lauchLogin()
        fun lauchAbout()
    }

}