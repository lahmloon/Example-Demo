package com.akexorcist.lovelyrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailAdapter3
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem3
import com.akexorcist.lovelyrecyclerview.viewmodels.RecyclerActivityViewModel3
import kotlinx.android.synthetic.main.activity_recycle_view3.*


class RecycleView3 : AppCompatActivity() {
    lateinit var recyclerViewAdapter: OrderDetailAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view3)
        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecycleView3)
            recyclerViewAdapter = OrderDetailAdapter3()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }



    private fun createData() {
        @Suppress("DEPRECATION") val viewModel = ViewModelProviders.of(this).get(
            RecyclerActivityViewModel3::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<OrderDetailItem3.RecyclerList>{

            if(it != null) {
                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@RecycleView3, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }

        })
        searchButton.setOnClickListener {
            viewModel.makeApiCall(searchBoxId.text.toString())
        }
    }
}