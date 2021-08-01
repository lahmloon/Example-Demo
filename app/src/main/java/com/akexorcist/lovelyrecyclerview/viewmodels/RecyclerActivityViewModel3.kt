package com.akexorcist.lovelyrecyclerview.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem3.RecyclerList
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork3

class RecyclerActivityViewModel3: ViewModel() {

    var recyclerListData: MutableLiveData<RecyclerList> = MutableLiveData()


    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList> {
        return recyclerListData
    }

    fun makeApiCall(input: String) {
        FakeNetwork3.getFakeOrderDetail(input, recyclerListData)
    }
}