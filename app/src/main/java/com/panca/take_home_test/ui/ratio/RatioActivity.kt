package com.panca.take_home_test.ui.ratio

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.panca.take_home_test.R
import com.panca.take_home_test.base.BaseActivity
import com.panca.take_home_test.databinding.ActivityRatioBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import timber.log.Timber

class RatioActivity : BaseActivity<ActivityRatioBinding>(), KodeinAware {

    override val kodein by kodein()

    private val viewModelFactory: RatioViewModelFactory by instance()

    private lateinit var ratioViewModel: RatioViewModel
    override val bindingInflater: (LayoutInflater) -> ActivityRatioBinding
        get() = ActivityRatioBinding::inflate

    override fun setup() {
        setUpViewModel()
        supportActionBar!!.title = "Perbandiangan"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        val tabTitle = arrayOf("Imbal Hasil", "Dana Kelola")
        val tabAdapter = RatioTabAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    private fun setUpViewModel() {
        ratioViewModel = ViewModelProvider(this, viewModelFactory).get(RatioViewModel::class.java)
    }

}