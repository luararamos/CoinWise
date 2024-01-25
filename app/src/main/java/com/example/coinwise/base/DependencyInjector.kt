package com.example.coinwise.base

import android.content.Context
import com.example.coinwise.coin.data.CoinRepository

object DependencyInjector {
    fun coinRepository(context: Context): CoinRepository {
        return CoinRepository(context)
    }
}