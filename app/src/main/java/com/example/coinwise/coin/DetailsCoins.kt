package com.example.coinwise.coin

import com.example.coinwise.coin.model.Ticker
import com.example.coinwise.coin.presentation.CoinDetailsPresenter

interface DetailsCoins {
    interface Presenter {
        fun findCoin(coinName: String?)
    }

    interface View {
        var presenter: CoinDetailsPresenter
        fun progressbar(visibility: Boolean)
        fun showCoin(coin: Ticker)
        fun showError(e: String)
    }
}