package com.example.coinwise.base

import android.content.Context
import com.example.coinwise.data.CoinRepository

object DependencyInjector {
    fun coinRepository(context: Context): CoinRepository {
        return CoinRepository(context)
    }
}