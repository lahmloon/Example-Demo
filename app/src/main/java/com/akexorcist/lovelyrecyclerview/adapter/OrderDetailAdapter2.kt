package com.akexorcist.lovelyrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.holder.*
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.databinding.ViewEmptyBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewNoOrderBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewOrder2Binding
import com.akexorcist.lovelyrecyclerview.databinding.ViewSectionBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewTitleBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewUserDetailBinding

class OrderDetailAdapter2(
        private val onOrderRemoveClicked: (OrderDetailItem2.Order) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var orderDetailItems: List<OrderDetailItem2> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        OrderDetailType.TYPE_USER_DETAIL ->
            UserDetailViewHolder2(ViewUserDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_TITLE ->
            TitleViewHolder2(ViewTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_ORDER ->
            OrderViewHolder2(ViewOrder2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_EMPTY ->
            EmptyViewHolder(ViewEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_NO_ORDER ->
            NoOrderViewHolder(ViewNoOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        else ->
            throw NullPointerException("View Type $viewType doesn't match with any existing order detail type")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        orderDetailItems.getOrNull(position)?.let { item ->
            when {
                holder is UserDetailViewHolder2 && item is OrderDetailItem2.UserDetail -> holder.bind(item)
                holder is TitleViewHolder2 && item is OrderDetailItem2.Title -> holder.bind(item)
                holder is OrderViewHolder2 && item is OrderDetailItem2.Order -> holder.bind(item) { onOrderRemoveClicked.invoke(item) }
                holder is EmptyViewHolder && item is OrderDetailItem2.Empty -> {
                    /* Do nothing */
                }
                holder is NoOrderViewHolder && item is OrderDetailItem2.NoOrder -> {
                    /* Do nothing */
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = orderDetailItems.getOrNull(position)?.type
            ?: OrderDetailType.TYPE_EMPTY

    override fun getItemCount(): Int = orderDetailItems.size
}