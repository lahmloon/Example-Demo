package com.akexorcist.lovelyrecyclerview.util

import android.content.Context
import com.gundamd.thai_postcode_sdk.ThaiPostcodeSDK
import com.gundamd.thai_postcode_sdk.data.ThaiAddress
import kotlinx.coroutines.*

@Suppress("LocalVariableName")
class PostcodeUtils {
    companion object {
         suspend fun getPostCode(context: Context, district: String, province: String): ThaiAddress? = withContext(Dispatchers.Default) {
             var thaiAddressList = ThaiPostcodeSDK.instance().searchByProvince(province, 1000)
             if (thaiAddressList != null) {
                 for (thaiAddress in thaiAddressList!!) {
                     if (thaiAddress.province != null) if (thaiAddress.district == district && thaiAddress.province == province) {
                         return@withContext thaiAddress
                     }
                 }
             }
             return@withContext null
        }
    }
}

