package com.akexorcist.lovelyrecyclerview

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
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
            val intent = Intent(this, RecycleView1::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Intent Button1")
            }
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, RecycleView2::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Intent Button2")
            }
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Intent Button3")
            }
            startActivity(intent)
        }
    }
}
