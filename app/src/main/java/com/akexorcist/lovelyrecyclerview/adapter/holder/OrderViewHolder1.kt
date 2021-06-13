package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.databinding.ViewOrderBinding

class OrderViewHolder1(private val binding: ViewOrderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem1.Order, onLongClicked: () -> Unit) {
        binding.tvOrderName.text = item.name
        binding.tvOrderDetail.text = item.detail
        binding.tvOrderPrice.text = item.price
        binding.root.setOnLongClickListener {
            onLongClicked.invoke()
            true
        }
    }
}
