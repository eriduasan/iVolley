package com.example.volleyball.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.volleyball.R
import com.example.volleyball.clases.Faq

class FaqAdapter(private val faqList: MutableList<Faq>, private val context: Context, private val onClick: (Faq) -> Unit?): RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    class FaqViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvFaqTitle: TextView = view.findViewById(R.id.faq_item_title)

        fun bindItem(faq: Faq) {
            tvFaqTitle.text = faq.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.faq_item, parent, false)

        return FaqViewHolder(view)

    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.bindItem(faqList[position])
        holder.itemView.setOnClickListener{ onClick(faqList[position]) }
    }

}