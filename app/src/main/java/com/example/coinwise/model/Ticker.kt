package com.example.coinwise.model

import com.google.gson.annotations.SerializedName

data class Ticker(
    @SerializedName("high") val high: Double,
    @SerializedName("low") val low: Double,
    @SerializedName("vol") val vol: Double,
    @SerializedName("last") val last: Double,
    @SerializedName("buy") val buy: Double,
    @SerializedName("sell") val sell: Double,
    @SerializedName("open") val open: Double,
    @SerializedName("date") val date: Double
)