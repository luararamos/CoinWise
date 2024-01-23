package com.example.coinwise.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.coinwise.R
import com.example.coinwise.databinding.ActivityCoinDetailsBinding
import com.example.coinwise.model.Ticker
import com.example.coinwise.presentation.CoinDetailsPresenter

class CoinDetailsActivity : AppCompatActivity() {
    val presenter = CoinDetailsPresenter(this)

    private lateinit var binding: ActivityCoinDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val coin = intent.extras?.getString("coin")
        binding.txtCoin.text = coin
        setImageCoin(coin)
        presenter.findCoin(coin)


    }

    private fun setImageCoin(coin: String?){
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
    fun showCoin(coin: Ticker) {
        binding.txtHighCoinDetails.text = coin.high.toString()
        binding.txtLowCoinDetails.text = coin.low.toString()
        binding.txtVolCoinDetails.text = coin.vol.toString()
        binding.txtLastCoinDetails.text = coin.last.toString()
        binding.txtBuyCoinDetails.text = coin.buy.toString()
        binding.txtSellCoinDetails.text = coin.sell.toString()
        binding.txtOpenCoinDetails.text = coin.open.toString()
        binding.txtDateCoinDetails.text = coin.date.toString()
    }

    fun progressbar(visibility: Boolean){
        if (visibility) {
            binding.progressbarActivityDetails.visibility = View.VISIBLE
        } else {
            binding.progressbarActivityDetails.visibility = View.GONE
        }
    }

    fun showError(e: String){
        Toast.makeText(this,e, Toast.LENGTH_SHORT).show()
    }
}