package com.akexorcist.lovelyrecyclerview.util

import android.content.Context
import com.lahmloon.occupations_isic_code_sdk.OccupationsSdk
import com.lahmloon.occupations_isic_code_sdk.occupations.data.Occupations
import kotlinx.coroutines.*

@Suppress("LocalVariableName")
class OccupationsUtils {
    companion object {
        suspend fun getOccupationsList(
            context: Context,
            code: String,
            count: Int
        ): List<Occupations>? = withContext(Dispatchers.Default) {
            var occupationsList =
                OccupationsSdk.instance(context).searchOccupationsByIsicCode(code, count)
            if (occupationsList != null) {
                return@withContext occupationsList
            }
            return@withContext null
        }
    }
}

