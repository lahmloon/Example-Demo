package com.akexorcist.lovelyrecyclerview.network.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Mars(
        @SerializedName("price")
        val price: Int,
        @SerializedName("id")
        val id: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("img_src")
        @Json(name = "img_src")
        val imgSrcUrl: String

) : Parcelable
