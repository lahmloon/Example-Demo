package com.akexorcist.lovelyrecyclerview.network

import androidx.lifecycle.MutableLiveData
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem3
import com.akexorcist.lovelyrecyclerview.network.retrofit.RecycleService3
import com.demo.myfirstapp.network.NetworkProvider3
import retrofit2.Call
import retrofit2.Response

object FakeNetwork3 {
    fun getFakeOrderDetail(input: String, recyclerListData: MutableLiveData<OrderDetailItem3.RecyclerList>) {
        val retroInstance = NetworkProvider3.getRetroInstance().create(RecycleService3::class.java)
        val call = retroInstance.getDataFromAPI(input)
        call.enqueue(object : retrofit2.Callback<OrderDetailItem3.RecyclerList>{
            override fun onResponse(call: Call<OrderDetailItem3.RecyclerList>, response: Response<OrderDetailItem3.RecyclerList>) {
                if(response.isSuccessful) {
                    //recyclerViewAdapter.setListData(response.body()?.items!!)
                    //recyclerViewAdapter.notifyDataSetChanged()
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<OrderDetailItem3.RecyclerList>, t: Throwable) {
                // Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()

                recyclerListData.postValue(null)
            }
        })
    }
}
