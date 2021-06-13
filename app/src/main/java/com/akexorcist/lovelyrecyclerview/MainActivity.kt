package com.akexorcist.lovelyrecyclerview

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.lovelyrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // view binding
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.button1.setOnClickListener {
            intent("Intent Button1", RecycleView1::class.java)
        }
        binding.button2.setOnClickListener {
            intent("Intent Button2", RecycleView1::class.java)
        }
    }

    private fun intent(message : String, gotoActivity : Class<RecycleView1>) {
        val intent = Intent(this, gotoActivity).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
