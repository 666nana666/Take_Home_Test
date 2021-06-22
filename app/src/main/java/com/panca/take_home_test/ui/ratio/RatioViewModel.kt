package com.panca.take_home_test.ui.ratio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.launch
import timber.log.Timber

class RatioViewModel (): ViewModel() {
    init {

    }

     val data1: ArrayList<Entry> = ArrayList()
     val entryData : MutableLiveData<ArrayList<Entry>> = MutableLiveData()
    fun fetchRatioData() = viewModelScope.launch {

 Timber.d("post Value fetch Ratio Data")
        data1.add(Entry(1f, 0f))
        data1.add(Entry(2f, 10f))
        data1.add(Entry(3f, 40f))
        entryData.postValue(
            data1
        )
    }
}