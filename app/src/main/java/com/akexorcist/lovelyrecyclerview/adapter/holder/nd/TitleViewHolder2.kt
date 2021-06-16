package com.akexorcist.lovelyrecyclerview.adapter.holder.nd

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.databinding.ViewTitleBinding

class TitleViewHolder2(private val binding: ViewTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem2.Title) {
        binding.tvTitle.text = item.title
    }
}
