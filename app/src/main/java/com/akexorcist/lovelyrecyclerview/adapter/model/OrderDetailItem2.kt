package com.akexorcist.lovelyrecyclerview.adapter.model

import android.os.Parcelable
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType
//import kotlinx.parcelize.Parcelize

sealed class OrderDetailItem2(val type: Int) {

//    @Parcelize
    data class UserDetail(
            val name: String
    ) : OrderDetailItem2(OrderDetailType.TYPE_USER_DETAIL)

//    @Parcelize
    data class Title(
            val title: String
    ) : OrderDetailItem2(OrderDetailType.TYPE_TITLE)

//    @Parcelize
    data class Order(
        val name: String,
        val detail: String,
        val price: String,
        val img: String
    ) : OrderDetailItem2(OrderDetailType.TYPE_ORDER)

//    @Parcelize
    object Empty : OrderDetailItem2(OrderDetailType.TYPE_EMPTY)

//    @Parcelize
    object NoOrder : OrderDetailItem2(OrderDetailType.TYPE_NO_ORDER)
}
