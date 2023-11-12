package com.example.volleyball.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentAboutBinding

class AboutFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)

        binding.btnGoBack.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(p0: View?) {
        OnBackPressedDispatcher().onBackPressed().apply {  }
    }


}