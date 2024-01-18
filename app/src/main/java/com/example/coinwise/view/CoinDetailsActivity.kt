package com.example.coinwise.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.coinwise.R
import com.example.coinwise.databinding.ActivityCoinDetailsBinding

class CoinDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoinDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val coin = intent.extras?.getString("coin")
        binding.txtCoin.text = coin
        when (coin) {
            "ADA" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_ada
                )
            )

            "BNB" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bnb
                )
            )

            "BTC" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_btc
                )
            )

            "DOGE" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_doge
                )
            )

            "ETH" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_eth
                )
            )

            "USDT" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_usdt
                )
            )

            "XRP" -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_xrp
                )
            )

            else -> binding.cvCoinActivityDeatails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_information
                )
            )
        }

    }
}