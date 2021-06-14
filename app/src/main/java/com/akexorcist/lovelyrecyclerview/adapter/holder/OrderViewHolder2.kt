package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.R
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.databinding.ViewOrder2Binding
import com.bumptech.glide.Glide

class OrderViewHolder2(private val binding: ViewOrder2Binding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem2.Order, onLongClicked: () -> Unit) {
        binding.tvOrderName.text = item.name
        binding.tvOrderDetail.text = item.detail
        binding.tvOrderPrice.text = item.price
        binding.root.setOnLongClickListener {
            onLongClicked.invoke()
            true
        }
        val iv = binding.ivOrders
        Glide.with(iv)
                .load("https://avatars.githubusercontent.com/u/1572684?v=4")
                .circleCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .fallback(R.drawable.ic_loading)
                .into(iv)
    }
}
