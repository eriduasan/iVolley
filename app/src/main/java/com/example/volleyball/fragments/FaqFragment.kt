package com.example.volleyball.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.volleyball.R
import com.example.volleyball.adapters.FaqAdapter
import com.example.volleyball.clases.Faq
import com.example.volleyball.databinding.FragmentFaqBinding


class FaqFragment : Fragment() {

    lateinit var binding: FragmentFaqBinding
    var faqListener : onFaqFragmentItemClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is onFaqFragmentItemClicked) {
            faqListener = context
        } else {
            throw Exception(context.javaClass.simpleName + " must implement onFaqFragmentItemClicked")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFaqBinding.inflate(inflater)

        val faqs = mutableListOf(
            Faq(getString(R.string.faq_volleyball_scoring_title), getString(R.string.faq_volleyball_scoring_body)),
            Faq(getString(R.string.faq_what_to_wear_title), getString(R.string.faq_what_to_wear_body)),
            Faq(getString(R.string.faq_libero_title), getString(R.string.faq_libero_body)),
            Faq(getString(R.string.faq_libero_diff_title), getString(R.string.faq_libero_diff_body)),
            Faq(getString(R.string.faq_libero_color_title), getString(R.string.faq_libero_color_body)),
            Faq(getString(R.string.faq_volleyball_positions_title), getString(R.string.faq_volleyball_positions_body))
        )

        val itemClicked = { faq: Faq ->
            faqListener?.clickFaqItem(faq)
        }

        binding.faqRecview.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.faqRecview.adapter = FaqAdapter(faqs, requireContext(), itemClicked)
        binding.faqRecview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    interface onFaqFragmentItemClicked {
        fun clickFaqItem(faq: Faq)
    }

}