package com.akexorcist.lovelyrecyclerview.adapter.holder.st

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.databinding.ViewUserDetailBinding

class UserDetailViewHolder1(private val binding: ViewUserDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem1.UserDetail) {
        binding.tvUserName.text = item.name
    }
}
