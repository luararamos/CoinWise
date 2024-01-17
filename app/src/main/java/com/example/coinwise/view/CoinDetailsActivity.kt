package com.example.coinwise.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coinwise.R
import com.example.coinwise.databinding.ActivityCoinDetailsBinding

class CoinDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCoinDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val coin = intent.extras?.getString("coin")
        binding.txtCoin.text = coin
    }

}