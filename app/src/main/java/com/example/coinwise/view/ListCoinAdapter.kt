package com.example.coinwise.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coinwise.R

class ListCoinAdapter(
    private val list: List<String>,
    private val onItemClickListener: (String)-> Unit
) : RecyclerView.Adapter<ListCoinAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder.bind(item)

    }

    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            val textCoin = itemView.findViewById<TextView>(R.id.txt_coin)
            val imgCoin = itemView.findViewById<ImageView>(R.id.img_coin)


            textCoin.text = item

            itemView.setOnClickListener {
                onItemClickListener.invoke(item)
            }
            when(item){
                "ADA" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_ada))
                "BNB" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_bnb))
                "BTC" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_btc))
                "DOGE" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_doge))
                "ETH" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_eth))
                "USDT" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_usdt))
                "XRP" -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_xrp))
                else -> imgCoin.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_information))
            }

        }
    }
}