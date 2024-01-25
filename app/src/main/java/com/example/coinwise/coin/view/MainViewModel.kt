package com.example.coinwise.coin.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val arrayListLiveData = MutableLiveData<List<String>>()
}