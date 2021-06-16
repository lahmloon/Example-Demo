package com.akexorcist.lovelyrecyclerview.adapter.model

import android.os.Parcelable
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType
//import kotlinx.parcelize.Parcelize

sealed class OrderDetailItem1(val type: Int) {
//    @Parcelize
    data class UserDetail(
        val name: String
    ) : OrderDetailItem1(OrderDetailType.TYPE_USER_DETAIL)

//    @Parcelize
    data class Title(
        val title: String
    ) : OrderDetailItem1(OrderDetailType.TYPE_TITLE)

//    @Parcelize
    data class Section(
        val section: String,
        val backgroundColor: Int
    ) : OrderDetailItem1(OrderDetailType.TYPE_SECTION)

//    @Parcelize
    data class Order(
        val name: String,
        val detail: String,
        val price: String
    ) : OrderDetailItem1(OrderDetailType.TYPE_ORDER)

//    @Parcelize
    data class Summary(
        val name: String,
        val price: String
    ) : OrderDetailItem1(OrderDetailType.TYPE_SUMMARY)

//    @Parcelize
    data class Total(
        val totalPrice: String
    ) : OrderDetailItem1(OrderDetailType.TYPE_TOTAL)

//    @Parcelize
    object Notice : OrderDetailItem1(OrderDetailType.TYPE_NOTICE)

//    @Parcelize
    object Button : OrderDetailItem1(OrderDetailType.TYPE_BUTTON)

//    @Parcelize
    object Empty : OrderDetailItem1(OrderDetailType.TYPE_EMPTY)

//    @Parcelize
    object NoOrder : OrderDetailItem1(OrderDetailType.TYPE_NO_ORDER)
}
