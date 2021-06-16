package com.akexorcist.lovelyrecyclerview.network.retrofit

import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem3.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecycleService3 {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>

}