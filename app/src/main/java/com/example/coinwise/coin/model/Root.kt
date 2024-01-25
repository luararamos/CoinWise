package com.example.coinwise.coin.model

import com.google.gson.annotations.SerializedName

data class Root(
    @SerializedName("ticker") val ticker: Ticker
)
