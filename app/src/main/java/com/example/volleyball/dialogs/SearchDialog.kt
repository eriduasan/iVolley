package com.example.volleyball.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.volleyball.R
import kotlin.math.absoluteValue

class SearchDialog(private val onclick: (year: String) -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val view = inflater.inflate(R.layout.search_dialog, null)

            builder
                .setView(view)
                .setPositiveButton(
                    getString(R.string.search_dialog_btn)
                ) { dialog, id ->

                    val year = view.findViewById<EditText>(R.id.search_dialog_et_year).text.toString()
                    onclick(year)

                }

            builder.create()

        } ?: throw Exception("Activity cannot be null")
    }
}