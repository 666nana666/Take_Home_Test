package com.panca.take_home_test.ui.yield

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.tabs.TabLayoutMediator
import com.panca.take_home_test.R
import com.panca.take_home_test.base.BaseFragment
import com.panca.take_home_test.databinding.FragmentYieldBinding
import com.panca.take_home_test.ui.ratio.RatioViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class YieldFragment : BaseFragment<FragmentYieldBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentYieldBinding
        get() = FragmentYieldBinding::inflate

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(RatioViewModel::class.java)
    }
    private lateinit var data1: ArrayList<Entry>
    private lateinit var data2: ArrayList<Entry>
    private lateinit var data3: ArrayList<Entry>
    override fun setup() {


        data1 = ArrayList()
        data2 = ArrayList()
        data3 = ArrayList()
        data1.add(Entry(1f, 0f))
        data1.add(Entry(2f, 10f))
        data1.add(Entry(3f, 40f))
         data2.add(Entry(1f, 0f))
        data2.add(Entry(2f, 5f))
        data2.add(Entry(3f, 25f))
        data3.add(Entry(1f, 0f))
        data3.add(Entry(2f, 2.5f))
        data3.add(Entry(3f, 10f))
         configureLineChart()
        setUpTabLayout()
    }


    private fun setUpTabLayout() {
        val tabTitle = arrayOf("1 W","1 M", "1 Y","3 Y","5 Y","10 Y","ALL")
        val tabAdapter = YieldTabAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
    private fun configureLineChart() {
        val desc = Description()
        desc.textSize = 0F
        desc.text = " "
        val xAxis: XAxis = binding.lineChartYield.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = object : ValueFormatter() {
            private val mFormat: SimpleDateFormat = SimpleDateFormat("MMM dd", Locale.ENGLISH)
            override fun getFormattedValue(value: Float): String {
                val millis = value.toLong() * 75000000L
                return mFormat.format(Date(millis))
            }
        }
        binding.lineChartYield.axisLeft.isEnabled = false

        val dataSets = ArrayList<ILineDataSet>()

        dataSets.add(setData(data1, R.color.green))
        dataSets.add(setData(data2, R.color.violet))
        dataSets.add(setData(data3, R.color.blue))

        val data = LineData(dataSets)
        binding.lineChartYield.data = data

        binding.lineChartYield.setTouchEnabled(false)
    }

    private fun setData(listEntry: ArrayList<Entry>, color: Int): LineDataSet {
        val lineDataSet = LineDataSet(listEntry, " ")
        lineDataSet.color = color
        lineDataSet.setDrawValues(false)
        lineDataSet.circleSize = 8f
        lineDataSet.circleHoleRadius = 6f
        lineDataSet.setCircleColor(color)
        lineDataSet.lineWidth = 3f
        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineDataSet.axisDependency = YAxis.AxisDependency.LEFT
        return lineDataSet
    }

}