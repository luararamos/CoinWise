package com.example.coinwise.coin.db

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = value.split(Coin.SEPARATOR).map { it.trim() }
}