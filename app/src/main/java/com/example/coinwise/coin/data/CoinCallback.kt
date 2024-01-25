package com.example.coinwise.coin.data

import com.example.coinwise.coin.model.Ticker

interface CoinCallback {
    fun onSuccess( response: Ticker)
    fun onError(response: String)
    fun onComplete()
}