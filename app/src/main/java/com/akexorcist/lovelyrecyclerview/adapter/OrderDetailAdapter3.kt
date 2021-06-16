package com.akexorcist.lovelyrecyclerview.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.R
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem3
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class OrderDetailAdapter3: RecyclerView.Adapter<OrderDetailAdapter3.MyViewHolder>()  {

    var items = ArrayList<OrderDetailItem3>()

    fun setListData(data: ArrayList<OrderDetailItem3>) {
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailAdapter3.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvTitle = view.tvTitle
        val tvDesc = view.tvDesc
        val imageThumb = view.imageThumb

        fun bind(data: OrderDetailItem3) {
            tvTitle.text = data.name
            if(!TextUtils.isEmpty(data.description)) {
                tvDesc.text = data.description
            } else {
                tvDesc.text = "No Desc available."
            }

            val url = data.owner.avatar_url
            Glide.with(imageThumb)
                    .load(url)
                    .circleCrop()
                    .placeholder(R.drawable.default_thumb)
                    .error(R.drawable.default_thumb)
                    .fallback(R.drawable.default_thumb)
                    .into(imageThumb)
        }

    }

}