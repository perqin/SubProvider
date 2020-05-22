package com.perqin.subprovider.ui.pages.sources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.perqin.subprovider.R
import kotlinx.android.synthetic.main.fragment_sources.view.*

class SourcesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sources, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(view.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = SourcesRecyclerViewAdapter()
        }
    }

    companion object {
        fun newInstance() = SourcesFragment()
    }
}