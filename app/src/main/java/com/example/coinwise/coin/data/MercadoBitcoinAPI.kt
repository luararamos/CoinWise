package com.example.coinwise.coin.data

import com.example.coinwise.coin.model.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoBitcoinAPI {
    @GET("{coin}/ticker")
    fun findCoin( @Path("coin")coinName:String? = null ): Call<Root>

}