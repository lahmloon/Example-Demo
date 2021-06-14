package com.akexorcist.lovelyrecyclerview.util

import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail2

object OrderDetailConverter2 {
    fun createUserDetail(name: String): OrderDetailItem2.UserDetail {
        return OrderDetailItem2.UserDetail(
                name = name
        )
    }

    fun createTitle(title: String): OrderDetailItem2.Title {
        return OrderDetailItem2.Title(
                title = title
        )
    }

    fun createSectionAndOrder(
            orderDetail: OrderDetail2,
            currency: String,
    ): List<OrderDetailItem2> {
        return mutableListOf<OrderDetailItem2>().apply {
            // Food
            if (!orderDetail.mars.isNullOrEmpty()) {
                addAll(
                        orderDetail.mars.map { mars ->
                            OrderDetailItem2.Order(
                                    name = mars.id,
                                    detail = "x${mars.type}",
                                    price = "${mars.price}$currency",
                                    img = mars.imgSrcUrl
                            )
                        })
            }

        }
    }
}
