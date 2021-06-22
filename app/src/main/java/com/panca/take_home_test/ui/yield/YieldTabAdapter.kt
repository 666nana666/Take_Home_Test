package com.panca.take_home_test.ui.yield

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.panca.take_home_test.ui.date.DateFragment

class YieldTabAdapter(fragment: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragment,lifecycle) {

    private val fragments:ArrayList<Fragment> = arrayListOf(
        DateFragment(),
        DateFragment(),
        DateFragment(),
        DateFragment(),
        DateFragment(),
        DateFragment(),
        DateFragment(),
    )


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}