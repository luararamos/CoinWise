package com.example.coinwise.data

import android.content.Context
import com.example.coinwise.db.AppDatabase
import com.example.coinwise.db.CoinTable
import io.reactivex.Completable
import io.reactivex.Single

class CoinRepository(context: Context) {
    private val dao = AppDatabase.getDatabase(context).coinDao()

    fun insertCoin(coin: CoinTable): Completable {
        return dao.insert(coin)
    }

    fun updateCoin(coin: CoinTable): Completable {
        return dao.updateCoin(coin)

    }
    fun findAllCoin(): Single<List<CoinTable>> {
        return dao.getAllCoin()
    }

    fun deleteCoin(id: Int): Completable {
        return dao.delete(id)
    }
}