package com.example.coinwise.coin

import com.example.coinwise.coin.db.CoinTable
import com.example.coinwise.coin.presentation.CoinPresenter

interface RegisterCoins {

    interface Presenter {
        fun addCoin(coin: CoinTable)
        fun removeCoin(coinId: Int)
        fun findCoins()
        fun updateCoin(coin : CoinTable)
        fun onDestroy()
    }

    interface View{
        var presenter: CoinPresenter
        fun onRestartView()
        fun onGetCoin(l: List<String>)
    }
}