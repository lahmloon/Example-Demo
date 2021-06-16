package com.akexorcist.lovelyrecyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailAdapter2
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem2
import com.akexorcist.lovelyrecyclerview.databinding.ActivityRecycleView1Binding
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork2
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail2
import com.akexorcist.lovelyrecyclerview.util.nd.OrderDetailConverter2
import com.akexorcist.lovelyrecyclerview.util.nd.OrderDetailDiffCallback2
import com.akexorcist.lovelyrecyclerview.view.TransparentProgressDialog
import com.google.gson.Gson

class RecycleView2 : AppCompatActivity() {
    private val binding: ActivityRecycleView1Binding by lazy { ActivityRecycleView1Binding.inflate(layoutInflater) }

    private lateinit var adapter: OrderDetailAdapter2

    private var orderDetail: OrderDetail2? = null

    private var dialog: TransparentProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        showLoadingView(this)
        loadOrderDetail()
    }


    private fun setupView() {
        adapter = OrderDetailAdapter2(onOrderRemoveClicked)
        binding.rvOrderDetail.layoutManager = LinearLayoutManager(this)
        binding.rvOrderDetail.adapter = adapter
    }

    private fun loadOrderDetail() {
        FakeNetwork2.getFakeOrderDetail { orderDetail ->
            this.orderDetail = orderDetail
            val convertedItems = convertToOrderDetailItems(orderDetail)
            updateOrderDetailItems(listOf(), convertedItems)
        }
    }

    private fun convertToOrderDetailItems(orderDetail: OrderDetail2): List<OrderDetailItem2> {
        val name = "Sleeping For Less"
        val title = getString(R.string.mars)

        val currency = getString(R.string.baht_unit)

        return mutableListOf<OrderDetailItem2>().apply {
            add(OrderDetailConverter2.createUserDetail(name))
            add(OrderDetailConverter2.createTitle(title))
            addAll(OrderDetailConverter2.createSectionAndOrder(orderDetail, currency))
        }
    }

    private fun updateOrderDetailItems(oldItems: List<OrderDetailItem2>, newItems: List<OrderDetailItem2>) {
        adapter.orderDetailItems = newItems
        DiffUtil.calculateDiff(OrderDetailDiffCallback2(oldItems, newItems))
                .dispatchUpdatesTo(adapter)
        dismissLoadingView()
    }

    private val onOrderRemoveClicked: (OrderDetailItem2.Order) -> Unit = { item ->
        orderDetail?.let { oldItems ->
            val gson = Gson()
            val newItems = gson.fromJson(gson.toJson(oldItems), OrderDetail2::class.java)
            newItems.mars?.removeAll { it.id == item.name && "x${it.price}" == item.detail }
            updateOrderDetailItems(convertToOrderDetailItems(oldItems), convertToOrderDetailItems(newItems))
            orderDetail = newItems
        }
    }

    private fun showLoadingView(context: Context) {
        dialog = TransparentProgressDialog(context, R.drawable.ic_loading, null)
        dialog!!.show()
    }

    private fun dismissLoadingView() {
        if (dialog != null)
            dialog!!.dismiss()
    }
}