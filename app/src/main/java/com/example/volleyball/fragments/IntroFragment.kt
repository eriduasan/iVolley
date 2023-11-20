package com.example.volleyball.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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

        val views = listOf(binding.textView, binding.textView3, binding.imageView, binding.btnLogin, binding.btnAbout)

        binding.btnLogin.setOnClickListener(this)
        binding.btnAbout.setOnClickListener(this)

        views.forEachIndexed { index, view ->
            view?.startAnimation(getAnimation((index * 150 + 500).toLong(), 400))
        }

        return binding.root
    }

    override fun onClick(view: View) {
        when(view.id){
            binding.btnLogin.id -> introInterface?.lauchLogin()
            binding.btnAbout.id -> introInterface?.lauchAbout()
        }
    }

    fun getAnimation( startOffset: Long, duration: Long): Animation {

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in_anim)

        animation.startOffset = startOffset
        animation.duration = duration
        animation.fillAfter = true

        return animation

    }

    interface onIntroFragmentButtonsClick {
        fun lauchLogin()
        fun lauchAbout()
    }

}