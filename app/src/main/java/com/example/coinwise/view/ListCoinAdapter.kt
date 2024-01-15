package com.example.coinwise.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coinwise.R

class ListCoinAdapter : RecyclerView.Adapter<ListCoinAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        fun bind() {
            val textCoin = item.findViewById<TextView>(R.id.txt_coin)
            val imgCoin = item.findViewById<ImageView>(R.id.img_coin)
            textCoin.text = "teste"
            imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_btc))

        }
    }
}