package com.example.coinwise.presentation

import android.annotation.SuppressLint
import android.view.View
import com.example.coinwise.data.CoinRepository
import com.example.coinwise.db.Coin
import com.example.coinwise.db.CoinTable
import com.example.coinwise.db.Converters
import com.example.coinwise.view.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    private var view: MainActivity,
    private var repository: CoinRepository
) {

    @SuppressLint("CheckResult")
    fun addCoin(coin: CoinTable) {
        repository.insertCoin(coin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }

    @SuppressLint("CheckResult")
    fun removeCoin(coinId: Int) {
        repository.deleteCoin(coinId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                onRestartView()
            }
            .subscribe()

    }

    @SuppressLint("CheckResult")
    fun findCoins() {
        repository.findAllCoin()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetCoin,
                this::onCoinFail
            )
    }

    @SuppressLint("CheckResult")
    fun updateCoin(coin : CoinTable) {
        repository.updateCoin(coin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                findCoins()
            }
            .subscribe()
    }


    private fun onRestartView(){
        view.onRestartView()
    }

    private fun onGetCoin(l: List<CoinTable>) {


        if (l.isNotEmpty()){
            val coin = l[0].coinList
            val listCoin = Converters().jsonToList(coin)
            view.onGetCoin(listCoin)
        }else{
            val list = listOf<String>()
            view.onGetCoin(list)

             addCoin(CoinTable(id = 1,Coin(listOf<String>("lista", "vazia")).convertCoinToString()))
        }

    }

    @SuppressLint("CheckResult")
    private fun onCoinFail(t: Throwable) {
        val list = listOf<String>("lista" , "vazia")
        repository.insertCoin(CoinTable(id = 1,coinList= Coin(list).convertCoinToString()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                findCoins()
            }
            .subscribe()
    }
}