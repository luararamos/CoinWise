package com.example.coinwise.data

import com.example.coinwise.model.Root
import retrofit2.Call
import retrofit2.http.GET

interface MercadoBitcoinAPI {

    @GET("BTC/ticker")
    fun findCoin(): Call<Root>

}