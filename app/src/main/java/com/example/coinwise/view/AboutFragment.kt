package com.example.coinwise.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coinwise.R
import com.example.coinwise.databinding.FragmentAboutBinding


class AboutFragment : Fragment(R.layout.fragment_about) {
    private var binding: FragmentAboutBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutBinding.bind(view)

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}