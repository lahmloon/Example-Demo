package com.akexorcist.lovelyrecyclerview.util

import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail1

object OrderDetailConverter1 {
    fun createUserDetail(name: String): OrderDetailItem1.UserDetail {
        return OrderDetailItem1.UserDetail(
                name = name
        )
    }

    fun createTitle(title: String): OrderDetailItem1.Title {
        return OrderDetailItem1.Title(
                title = title
        )
    }

    fun createTotal(orderDetail: OrderDetail1, currency: String): OrderDetailItem1.Total {
        val total = (orderDetail.foodList?.sumOf { it.price } ?: 0) +
                (orderDetail.bookList?.sumOf { it.price } ?: 0) +
                (orderDetail.musicList?.sumOf { it.price } ?: 0)
        return OrderDetailItem1.Total(
                totalPrice = "$total$currency",
        )
    }

    fun createNotice(): OrderDetailItem1.Notice {
        return OrderDetailItem1.Notice
    }

    fun createButton(): OrderDetailItem1.Button {
        return OrderDetailItem1.Button
    }

    fun createEmpty(): OrderDetailItem1.Empty {
        return OrderDetailItem1.Empty
    }

    fun createNoOrder(): OrderDetailItem1.NoOrder {
        return OrderDetailItem1.NoOrder
    }

    fun createSectionAndOrder(
            orderDetail: OrderDetail1,
            foodTitle: String,
            bookTitle: String,
            musicTitle: String,
            currency: String,
            foodTitleColor: Int,
            bookTitleColor: Int,
            musicTitleColor: Int
    ): List<OrderDetailItem1> {
        return mutableListOf<OrderDetailItem1>().apply {
            // Food
            if (!orderDetail.foodList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Section(
                                section = foodTitle,
                                backgroundColor = foodTitleColor
                        )
                )
                addAll(
                        orderDetail.foodList.map { food ->
                            OrderDetailItem1.Order(
                                    name = food.orderName,
                                    detail = "x${food.amount}",
                                    price = "${food.price}$currency"
                            )
                        })
            }

            // Book
            if (!orderDetail.bookList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Section(
                                section = bookTitle,
                                backgroundColor = bookTitleColor
                        )
                )
                addAll(
                        orderDetail.bookList.map { book ->
                            OrderDetailItem1.Order(
                                    name = book.bookName,
                                    detail = book.author,
                                    price = "${book.price}$currency"
                            )
                        })
            }

            // Music
            if (!orderDetail.musicList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Section(
                                section = musicTitle,
                                backgroundColor = musicTitleColor
                        )
                )
                addAll(
                        orderDetail.musicList.map { music ->
                            OrderDetailItem1.Order(
                                    name = music.album,
                                    detail = music.artist,
                                    price = "${music.price}$currency"
                            )
                        })
            }
        }
    }

    fun createSummary(
            orderDetail: OrderDetail1,
            foodTitle: String,
            bookTitle: String,
            musicTitle: String,
            currency: String
    ): List<OrderDetailItem1.Summary> {
        return mutableListOf<OrderDetailItem1.Summary>().apply {
            // Food
            if (!orderDetail.foodList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Summary(
                                name = foodTitle,
                                price = "${orderDetail.foodList.sumOf { it.price }}$currency"
                        )
                )
            }

            // Book
            if (!orderDetail.bookList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Summary(
                                name = bookTitle,
                                price = "${orderDetail.bookList.sumOf { it.price }}$currency"
                        )
                )
            }

            // Music
            if (!orderDetail.musicList.isNullOrEmpty()) {
                add(
                        OrderDetailItem1.Summary(
                                name = musicTitle,
                                price = "${orderDetail.musicList.sumOf { it.price }}$currency"
                        )
                )
            }
        }
    }
}
