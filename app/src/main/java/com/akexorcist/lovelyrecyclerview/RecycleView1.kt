package com.akexorcist.lovelyrecyclerview

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailAdapter1
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem1
import com.akexorcist.lovelyrecyclerview.databinding.ActivityRecycleView1Binding
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork1
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail1
import com.akexorcist.lovelyrecyclerview.util.OrderDetailConverter1
import com.akexorcist.lovelyrecyclerview.util.OrderDetailDiffCallback1
import com.akexorcist.lovelyrecyclerview.view.TransparentProgressDialog
import com.google.gson.Gson

class RecycleView1 : AppCompatActivity() {
    private val binding: ActivityRecycleView1Binding by lazy { ActivityRecycleView1Binding.inflate(layoutInflater) }

    private lateinit var adapter: OrderDetailAdapter1

    private var orderDetail: OrderDetail1? = null

    private var dialog: TransparentProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        showLoadingView(this)
        loadOrderDetail()
    }

    private fun setupView() {
        adapter = OrderDetailAdapter1(onPositiveButtonClicked, onNegativeButtonClicked, onOrderRemoveClicked)
        binding.rvOrderDetail.layoutManager = LinearLayoutManager(this)
        binding.rvOrderDetail.adapter = adapter
    }

    private fun loadOrderDetail() {
        FakeNetwork1.getFakeOrderDetail { orderDetail ->
            this.orderDetail = orderDetail
            val convertedItems = convertToOrderDetailItems(orderDetail)
            updateOrderDetailItems(listOf(), convertedItems)
        }
    }

    private fun convertToOrderDetailItems(orderDetail: OrderDetail1): List<OrderDetailItem1> {
        val name = "Sleeping For Less"
        val title = getString(R.string.your_order)
        val summaryTitle = getString(R.string.summary)

        val foodTitle = getString(R.string.food)
        val bookTitle = getString(R.string.book)
        val musicTitle = getString(R.string.music)
        val currency = getString(R.string.baht_unit)

        val foodTitleColor = ContextCompat.getColor(this, R.color.sky_light_blue)
        val bookTitleColor = ContextCompat.getColor(this, R.color.funny_dark_pink)
        val musicTitleColor = ContextCompat.getColor(this, R.color.natural_green)

        return if (isOrderDetailAvailable(orderDetail)) {
            mutableListOf<OrderDetailItem1>().apply {
                add(OrderDetailConverter1.createUserDetail(name))
                add(OrderDetailConverter1.createTitle(title))
                addAll(OrderDetailConverter1.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency, foodTitleColor, bookTitleColor, musicTitleColor))
                add(OrderDetailConverter1.createTitle(summaryTitle))
                addAll(OrderDetailConverter1.createSummary(orderDetail, foodTitle, bookTitle, musicTitle, currency))
                add(OrderDetailConverter1.createTotal(orderDetail, currency))
                add(OrderDetailConverter1.createNotice())
                add(OrderDetailConverter1.createButton())
            }
        } else {
            mutableListOf<OrderDetailItem1>().apply {
                add(OrderDetailConverter1.createUserDetail(name))
                add(OrderDetailConverter1.createTitle(title))
                add(OrderDetailConverter1.createNoOrder())
                add(OrderDetailConverter1.createTitle(summaryTitle))
                add(OrderDetailConverter1.createTotal(orderDetail, currency))
            }
        }
    }

    private fun isOrderDetailAvailable(orderDetail: OrderDetail1): Boolean {
        return orderDetail.foodList?.isNotEmpty() == true ||
                orderDetail.bookList?.isNotEmpty() == true ||
                orderDetail.musicList?.isNotEmpty() == true
    }

    private fun updateOrderDetailItems(oldItems: List<OrderDetailItem1>, newItems: List<OrderDetailItem1>) {
        adapter.orderDetailItems = newItems
        DiffUtil.calculateDiff(OrderDetailDiffCallback1(oldItems, newItems))
                .dispatchUpdatesTo(adapter)
        dismissLoadingView()
    }

    private val onPositiveButtonClicked: () -> Unit = {
        Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
    }

    private val onNegativeButtonClicked: () -> Unit = {
        Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
    }

    private val onOrderRemoveClicked: (OrderDetailItem1.Order) -> Unit = { item ->
        orderDetail?.let { oldItems ->
            val gson = Gson()
            val newItems = gson.fromJson(gson.toJson(oldItems), OrderDetail1::class.java)
            newItems.foodList?.removeAll { it.orderName == item.name && "x${it.amount}" == item.detail }
            newItems.bookList?.removeAll { it.bookName == item.name && it.author == item.detail }
            newItems.musicList?.removeAll { it.album == item.name && it.artist == item.detail }
            updateOrderDetailItems(convertToOrderDetailItems(oldItems), convertToOrderDetailItems(newItems))
            orderDetail = newItems
        }
    }

    private fun  showLoadingView(context : Context) {
        dialog = TransparentProgressDialog(context, R.drawable.ic_loading, null)
        dialog!!.show()
    }

    private fun  dismissLoadingView() {
        if (dialog != null)
            dialog!!.dismiss()
    }

}