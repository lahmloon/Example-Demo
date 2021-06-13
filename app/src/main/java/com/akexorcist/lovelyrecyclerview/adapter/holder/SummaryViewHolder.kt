package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.databinding.ViewSummaryBinding

class SummaryViewHolder(private val binding: ViewSummaryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem1.Summary) {
        binding.tvSummaryName.text = item.name
        binding.tvSummaryPrice.text = item.price
    }
}
