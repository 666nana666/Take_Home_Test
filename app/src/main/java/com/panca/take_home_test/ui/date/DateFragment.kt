package com.panca.take_home_test.ui.date

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.tabs.TabLayoutMediator
import com.panca.take_home_test.base.BaseFragment
import com.panca.take_home_test.databinding.FragmentDateBinding
import com.panca.take_home_test.ui.ratio.RatioTabAdapter

class DateFragment : BaseFragment<FragmentDateBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDateBinding
        get() = FragmentDateBinding::inflate

    override fun setup() {

    }

}