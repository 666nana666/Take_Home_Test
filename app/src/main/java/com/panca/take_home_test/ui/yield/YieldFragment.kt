package com.panca.take_home_test.ui.yield

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panca.take_home_test.R
import com.panca.take_home_test.base.BaseFragment
import com.panca.take_home_test.databinding.FragmentYieldBinding

class YieldFragment : BaseFragment<FragmentYieldBinding>(){
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentYieldBinding
        get() = FragmentYieldBinding::inflate

    override fun setup() {
    }

}