package com.example.coinwise.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Completable

@Dao
interface CoinDao {
    @Insert
    fun insert(coins: CoinTable): Completable

}