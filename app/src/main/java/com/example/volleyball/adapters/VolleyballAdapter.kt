package com.example.volleyball.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.volleyball.R
import com.example.volleyball.clases.Preliminary
import com.squareup.picasso.Picasso

class VolleyballAdapter(private val volleyballList: MutableList<Preliminary>, private val context: Context): RecyclerView.Adapter<VolleyballAdapter.VolleyballAdapterViewHolder>() {
    class VolleyballAdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val ivFlag: ImageView = view.findViewById(R.id.iv_volleyball_flag)
        private val tvTeamName: TextView = view.findViewById(R.id.tv_volleyball_teamName)

        fun bindItem(preliminaryItem: Preliminary) {
            tvTeamName.text = preliminaryItem.teamName
            Picasso.get().load(preliminaryItem.urlFlag).into(ivFlag)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolleyballAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.volleyball_item, parent, false)

        return VolleyballAdapterViewHolder(view)

    }

    override fun getItemCount(): Int {
        return volleyballList.size
    }

    override fun onBindViewHolder(holder: VolleyballAdapterViewHolder, position: Int) {
        val item = volleyballList[position]

        holder.bindItem(item)

    }
}