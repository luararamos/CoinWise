package com.example.coinwise.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coinwise.R
import com.example.coinwise.databinding.FragmentCoinDetailsBinding

class CoinDetailsFragment : Fragment(R.layout.fragment_coin_details) {
    private var binding: FragmentCoinDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coin =
            arguments?.getFloat(KEY_COIN) ?: throw IllegalArgumentException("coin not found")
    }

    companion object {
        const val KEY_COIN = "key_coin"
    }

}