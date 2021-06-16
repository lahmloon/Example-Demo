package com.akexorcist.lovelyrecyclerview.adapter.holder.st

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.databinding.ViewTitleBinding

class TitleViewHolder1(private val binding: ViewTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem1.Title) {
        binding.tvTitle.text = item.title
    }
}
