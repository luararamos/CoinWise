package com.example.coinwise.coin.data

import com.example.coinwise.coin.model.Root
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinRemoteDataSource {

    fun findCoin(callback: CoinCallback, coinName: String?) {
        HTTPClient.retrofit()
            .create(MercadoBitcoinAPI::class.java)
            .findCoin(coinName)
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