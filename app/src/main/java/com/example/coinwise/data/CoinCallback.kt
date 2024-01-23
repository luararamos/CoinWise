package com.example.coinwise.data

import com.example.coinwise.model.Ticker

interface CoinCallback {
    fun onSuccess( response: Ticker)
    fun onError(response: String)
    fun onComplete()
}