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
        binding.txtCoinActivityCoinDetails.text = coin
        setImageCoin(coin)
        presenter.findCoin(coin)

        setNavigationToGoBack()

    }

    private fun setNavigationToGoBack(){
        binding.toolbarActivityCoinDetails.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setImageCoin(coin: String?){
        when (coin) {
            "ADA" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_ada
                )
            )

            "BNB" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bnb
                )
            )

            "BTC" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_btc
                )
            )

            "DOGE" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_doge
                )
            )

            "ETH" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_eth
                )
            )

            "USDT" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_usdt
                )
            )

            "XRP" -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_xrp
                )
            )

            else -> binding.cvCoinActivityCoinDetails.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_information
                )
            )
        }
    }
    fun showCoin(coin: Ticker) {
        val txtHigh = getString(R.string.high)
        val txtLow = getString(R.string.low)
        val txtVol = getString(R.string.vol)
        val txtLast = getString(R.string.last)
        val txtBuy = getString(R.string.buy)
        val txtSell = getString(R.string.sell)
        val txtOpen = getString(R.string.open)
        binding.txtHighActivityCoinDetails.text = txtHigh.plus(coin.high.toString())
        binding.txtLowActivityCoinDetailss.text = txtLow.plus(coin.low.toString())
        binding.txtVolActivityCoinDetails.text = txtVol.plus(coin.vol.toString())
        binding.txtLastActivityCoinDetails.text = txtLast.plus(coin.last.toString())
        binding.txtBuyActivityCoinDetails.text = txtBuy.plus(coin.buy.toString())
        binding.txtSellActivityCoinDetails.text = txtSell.plus(coin.sell.toString())
        binding.txtOpenActivityCoinDetails.text = txtOpen.plus(coin.open.toString())
    }

    fun progressbar(visibility: Boolean){
        if (visibility) {
            binding.progressbarActivityCoinDetails.visibility = View.VISIBLE
        } else {
            binding.progressbarActivityCoinDetails.visibility = View.GONE
        }
    }

    fun showError(e: String){
        Toast.makeText(this,e, Toast.LENGTH_SHORT).show()
    }
}