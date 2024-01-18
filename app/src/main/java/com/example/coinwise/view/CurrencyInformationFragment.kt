package com.example.coinwise.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.coinwise.R
import com.example.coinwise.databinding.FragmentCurrencyInformationBinding

class CurrencyInformationFragment : Fragment(R.layout.fragment_currency_information) {
    private var binding: FragmentCurrencyInformationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrencyInformationBinding.bind(view)

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}