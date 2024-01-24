package com.example.coinwise.data

import com.example.coinwise.model.Root
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinRemoteDataSource {

    fun findCoin(callback: CoinCallback, coinName: String?) {
        when (coinName) {
            "ADA" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findADA()
            "BNB" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findBNB()
            "BTC" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findBTC()
            "DOGE" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findDOGE()
            "ETH" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findETH()
            "USDT" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findUSDT()
            "XRP" -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findXRP()
            else -> HTTPClient.retrofit().create(MercadoBitcoinAPI::class.java).findADA()
        }
            .enqueue(object : Callback<Root> {
                override fun onResponse(call: Call<Root>, response: Response<Root>) {
                    if (response.isSuccessful) {
                        val root = response.body()
                        root?.let {
                            callback.onSuccess(root.ticker)
                        }
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<Root>, t: Throwable) {
                    callback.onError(t.message ?: "Erro servidor")
                    callback.onComplete()
                }


            })

    }
}