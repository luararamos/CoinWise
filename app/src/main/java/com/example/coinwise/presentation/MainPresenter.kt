package com.example.coinwise.presentation

import android.annotation.SuppressLint
import com.example.coinwise.data.CoinRepository
import com.example.coinwise.db.CoinTable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    private var repository: CoinRepository
) {

    @SuppressLint("CheckResult")
    fun addCoin(coin: CoinTable) {
        repository.insertCoin(coin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }
}