package com.example.coinwise.data

import com.example.coinwise.model.Root
import retrofit2.Call
import retrofit2.http.GET

interface MercadoBitcoinAPI {

    @GET("BTC/ticker")
    fun findCoin(): Call<Root>

    @GET("ADA/ticker")
    fun findADA(): Call<Root>
    @GET("BNB/ticker")
    fun findBNB(): Call<Root>
    @GET("BTC/ticker")
    fun findBTC(): Call<Root>
    @GET("DOGE/ticker")
    fun findDOGE(): Call<Root>
    @GET("ETH/ticker")
    fun findETH(): Call<Root>
    @GET("USDT/ticker")
    fun findUSDT(): Call<Root>
    @GET("XRP/ticker")
    fun findXRP(): Call<Root>

}