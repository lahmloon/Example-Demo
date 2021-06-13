package com.akexorcist.lovelyrecyclerview.network

import android.os.Handler
import android.os.Looper
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail1
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail2
import com.google.gson.Gson

object FakeNetwork2 {
    fun getFakeOrderDetail(callback: (orderDetail: OrderDetail2) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            callback.invoke(createFakeOrderDetail())
        }, 2000)
    }

    private fun createFakeOrderDetail(): OrderDetail2 {
        val fakeJson = "{\"Success\":[{\"price\":450000,\"id\":\"424905\",\"type\":\"buy\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg\"},{\"price\":8000000,\"id\":\"424906\",\"type\":\"rent\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631300305227E03_DXXX.jpg\"}]}"
        return Gson().fromJson(fakeJson, OrderDetail2::class.java)
    }
}
