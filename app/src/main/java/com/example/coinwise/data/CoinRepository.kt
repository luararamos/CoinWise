package com.example.coinwise.data

import android.content.Context
import com.example.coinwise.db.AppDatabase
import com.example.coinwise.db.CoinTable
import io.reactivex.Completable

class CoinRepository(context: Context) {
    private val dao = AppDatabase.getDatabase(context).coinDao()

    fun insertCoin(coin: CoinTable): Completable {
        return dao.insert(coin)
    }
}