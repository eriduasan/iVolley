package com.example.volleyball.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentOptionsBinding
import com.google.android.material.snackbar.Snackbar

class OptionsFragment : Fragment() {

    lateinit var binding: FragmentOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOptionsBinding.inflate(inflater)


        handleNotificationButton()


        binding.optionsBtnAllowNotifications.setOnClickListener{
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.POST_NOTIFICATIONS),0)
            } else {
                Snackbar.make(requireContext(), binding.root, getString(R.string.permission_already_granted), Snackbar.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    fun handleNotificationButton() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            binding.optionsBtnAllowNotifications.setBackgroundColor(resources.getColor(R.color.success_color))
            binding.optionsBtnAllowNotifications.setTextColor(resources.getColor(R.color.black))
            binding.optionsBtnAllowNotifications.text = getString(R.string.permission_already_granted)
        }
    }

}