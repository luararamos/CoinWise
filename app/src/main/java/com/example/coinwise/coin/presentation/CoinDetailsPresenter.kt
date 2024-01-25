package com.example.coinwise.coin.presentation

import com.example.coinwise.coin.DetailsCoins
import com.example.coinwise.coin.data.CoinCallback
import com.example.coinwise.coin.data.CoinRemoteDataSource
import com.example.coinwise.coin.model.Ticker
import com.example.coinwise.coin.view.CoinDetailsActivity

class CoinDetailsPresenter(
    private val view: CoinDetailsActivity,
    private val dataSource: CoinRemoteDataSource = CoinRemoteDataSource()
) : CoinCallback, DetailsCoins.Presenter {

    override fun findCoin(coinName: String?) {
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