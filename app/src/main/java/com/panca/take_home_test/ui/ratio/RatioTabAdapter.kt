package com.panca.take_home_test.ui.ratio

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.panca.take_home_test.ui.yield.YieldFragment

class RatioTabAdapter(fragment: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragment,lifecycle) {

    private val fragments:ArrayList<Fragment> = arrayListOf(
        YieldFragment(),
        YieldFragment()
    )


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}