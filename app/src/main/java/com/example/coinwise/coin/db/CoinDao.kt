package com.example.coinwise.coin.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CoinDao {
    @Insert
    fun insert(coins: CoinTable): Completable

    @Update
    fun updateCoin(coins: CoinTable): Completable

    @Query("SELECT * FROM CoinTable")
    fun getAllCoin(): Single<List<CoinTable>>

    @Query("DELETE FROM CoinTable WHERE id = :coinId")
    fun delete(coinId: Int): Completable

}