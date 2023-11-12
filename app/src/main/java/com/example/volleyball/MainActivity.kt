package com.example.volleyball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.volleyball.databinding.ActivityMainBinding
import com.example.volleyball.fragments.AboutFragment


import com.example.volleyball.fragments.IntroFragment
import com.example.volleyball.fragments.LoginFragment

class MainActivity : AppCompatActivity(), IntroFragment.onIntroFragmentButtonsClick {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun lauchLogin() {
        supportFragmentManager.commit {
            addToBackStack(null)
            setReorderingAllowed(true)
            replace<LoginFragment>(binding.fragmentContainerView.id)
        }
    }

    override fun lauchAbout() {
        supportFragmentManager.commit {
            addToBackStack(null)
            setReorderingAllowed(true)
            replace<AboutFragment>(binding.fragmentContainerView.id)
        }
    }

}