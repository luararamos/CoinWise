package com.example.coinwise.coin.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CoinTable(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "coin_list", defaultValue = "CoinTable")  val coinList: String
) {
    constructor(baseCoin: Coin) : this(
        coinList = baseCoin.convertCoinToString()
    )
}