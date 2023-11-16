package com.example.volleyball.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.volleyball.R
import com.example.volleyball.databinding.FragmentDetailFaqBinding

class DetailFaqFragment : Fragment() {

    lateinit private var faqTitle: String
    lateinit private var faqBody: String
    lateinit var binding: FragmentDetailFaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            faqTitle = it.getString(DETAIL_FAQ_TITLE, "Faq title")
            faqBody = it.getString(DETAIL_FAQ_BODY, "Faq body")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailFaqBinding.inflate(inflater)

        binding.detailFaqTitle.text = faqTitle
        binding.detailFaqBody.text = faqBody

        return binding.root
    }

    companion object {
        val DETAIL_FAQ_TITLE = "DETAIL_FAQ_TITLE"
        val DETAIL_FAQ_BODY = "DETAIL_FAQ_BODY"
    }
}