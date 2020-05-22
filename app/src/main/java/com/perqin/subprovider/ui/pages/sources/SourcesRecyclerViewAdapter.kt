package com.perqin.subprovider.ui.pages.sources

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.perqin.subprovider.R
import com.perqin.subprovider.data.models.Source

import kotlinx.android.synthetic.main.item_source.view.*

class SourcesRecyclerViewAdapter: RecyclerView.Adapter<SourcesRecyclerViewAdapter.ViewHolder>() {
    var sources: List<Source> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_source, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = sources[position]
        holder.urlTextView.text = item.url
    }

    override fun getItemCount(): Int = sources.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val urlTextView: TextView = view.urlTextView
    }
}