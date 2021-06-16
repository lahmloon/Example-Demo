package com.akexorcist.lovelyrecyclerview.adapter.model

sealed class OrderDetailItem3 {
    data class RecyclerList(val items: ArrayList<OrderDetailItem3>)
    data class OrderDetailItem3(val name: String, val description: String, val owner: Owner)
    data class Owner(val avatar_url: String)
}