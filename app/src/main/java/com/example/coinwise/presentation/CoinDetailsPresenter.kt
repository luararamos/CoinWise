package com.example.coinwise.presentation

import com.example.coinwise.data.CoinCallback
import com.example.coinwise.data.CoinRemoteDataSource
import com.example.coinwise.model.Ticker
import com.example.coinwise.view.CoinDetailsActivity

class CoinDetailsPresenter(
    private val view: CoinDetailsActivity,
    private val dataSource: CoinRemoteDataSource = CoinRemoteDataSource()
) : CoinCallback{

    fun findCoin(coinName: String?) {
        view.progressbar(true)
        dataSource.findCoin(this, coinName)
    }
    override fun onSuccess(response: Ticker) {
        view.progressbar(false)
        view.showCoin(response)
    }

    override fun onError(response: String) {
        view.progressbar(false)
        view.showError(response)
    }

    override fun onComplete() {
        view.progressbar(false)
    }


}