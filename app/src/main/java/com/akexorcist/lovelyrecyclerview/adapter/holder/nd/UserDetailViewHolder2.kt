package com.akexorcist.lovelyrecyclerview.adapter.holder.nd

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.databinding.ViewUserDetailBinding

class UserDetailViewHolder2(private val binding: ViewUserDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem2.UserDetail) {
        binding.tvUserName.text = item.name
    }
}
