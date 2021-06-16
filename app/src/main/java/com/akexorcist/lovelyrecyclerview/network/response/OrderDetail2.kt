package com.akexorcist.lovelyrecyclerview.network.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
//import kotlinx.parcelize.Parcelize


@Keep
//@Parcelize
data class OrderDetail2(
        @SerializedName("Success")
        val mars: MutableList<Mars>?,
)
