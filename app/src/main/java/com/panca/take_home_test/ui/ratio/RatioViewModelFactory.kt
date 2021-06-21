package com.panca.take_home_test.ui.ratio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class RatioViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return  RatioViewModel() as T
    }
}