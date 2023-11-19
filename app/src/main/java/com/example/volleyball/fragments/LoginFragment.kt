package com.example.volleyball.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentLoginBinding
    private val USER_NAME = "admin"
    private val USER_PASSWD = "admin"
    private var loginInterface: LoginInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is LoginInterface) {
            loginInterface = context
        } else {
            throw Exception("Activity must implement LoginInterface interface")
        }
    }

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

        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)

        if (username == USER_NAME && passwd == USER_PASSWD) {
            loginInterface?.changeActivity()
        } else {
            Snackbar.make(binding.root, getString(R.string.login_failed_msg), Snackbar.LENGTH_SHORT).show()
        }
    }

    interface LoginInterface {
        fun changeActivity()
    }

}