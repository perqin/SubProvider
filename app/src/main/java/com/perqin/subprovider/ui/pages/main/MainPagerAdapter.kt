package com.perqin.subprovider.ui.pages.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.perqin.subprovider.ui.pages.sources.SourcesFragment

class MainPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return SourcesFragment.newInstance()
    }
}
