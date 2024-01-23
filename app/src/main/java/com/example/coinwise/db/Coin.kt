package com.example.coinwise.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


data class Coin(val coin: List<String>) {
    fun convertCoinToString(): String {
        val sb: StringBuilder = java.lang.StringBuilder()
        var firstInList = true
        for (s in coin) {
            if (!firstInList) sb.append(SEPARATOR)
            sb.append(s)
            firstInList = false
        }
        return sb.toString()
    }

    companion object {
        const val SEPARATOR = "~~"
    }
}