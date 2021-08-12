package com.akexorcist.lovelyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.lovelyrecyclerview.adapter.OccupationListAdapter
import com.akexorcist.lovelyrecyclerview.databinding.ActivityOccupationsBinding
import com.akexorcist.lovelyrecyclerview.util.OccupationsUtils
import com.akexorcist.lovelyrecyclerview.util.PostcodeUtils
import com.akexorcist.lovelyrecyclerview.viewmodels.OccupationsViewModel
import com.lahmloon.occupations_isic_code_sdk.occupations.data.Occupations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Occupations : AppCompatActivity() {

    private lateinit var binding: ActivityOccupationsBinding
    private val model: OccupationsViewModel by viewModels()
    private val listAdapter = OccupationListAdapter(this::onOccupationClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOccupationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSearch()
        setupList()

        model.occupations.observe(this, Observer { listAdapter.occupations = it })

        CoroutineScope(Dispatchers.IO).async {
            val postCodeObjectSuspend = PostcodeUtils.getPostCode(this@Occupations, "จอมพระ", "สุรินทร์")
            Log.d("postCodeObj", (postCodeObjectSuspend ?: "ไม่มีข้อมุล") as String)
        }
    }

    private fun onOccupationClicked(occupations: Occupations) {
        Toast.makeText(
            this,
            String.format(
                "Id : ${occupations.id}\n" +
                        "Sub Of : ${occupations.idSubOf}\n" +
                        "Name Tha : ${occupations.nameTh}\n" +
                        "Name Eng : ${occupations.nameEng}"
            ), Toast.LENGTH_LONG
        ).show()
    }

    private fun setupSearch() {
        binding.search.doAfterTextChanged {
            model.search(it?.toString() ?: "")
        }
    }

    private fun setupList() {
        val layoutManager = LinearLayoutManager(this@Occupations)
        val list = binding.occupations
        list.layoutManager = layoutManager
        list.adapter = listAdapter
        list.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(
            list.context,
            layoutManager.orientation
        )
        list.addItemDecoration(itemDecoration)
    }
}