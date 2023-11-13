package com.example.volleyball.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.volleyball.DashboardActivity
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentLoginBinding
    private val USER_NAME = "admin"
    private val USER_PASSWD = "admin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater)

        binding.btnLogin.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(p0: View?) {
        val username = binding.tvUsername.text.toString()
        val passwd = binding.tvPasswd.text.toString()

        if (username == USER_NAME && passwd == USER_PASSWD) {
            val intent = Intent(requireContext(), DashboardActivity::class.java)
            startActivity(intent)
        } else {
            Snackbar.make(binding.root, getString(R.string.login_failed_msg), Snackbar.LENGTH_SHORT).show()
        }
    }

}