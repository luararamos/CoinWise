package com.example.coinwise.coin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinwise.R
import com.example.coinwise.databinding.FragmentListCoinsBinding

class ListCoinFragment : Fragment(R.layout.fragment_list_coins) {
    private var binding: FragmentListCoinsBinding? = null
    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListCoinsBinding.bind(view)
        binding?.rvFragmentListCoin?.layoutManager = LinearLayoutManager(context)

        activity?.let {
            mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        }

        mainViewModel.arrayListLiveData.observe(viewLifecycleOwner) { arrayList ->

            showListCoin(arrayList)
        }

    }

    private fun showListCoin(coins: List<String>) {
        if (coins.isEmpty()) {
            val drawable = ContextCompat.getDrawable(this.requireContext(), R.drawable.unfiltered_message)
            binding?.imgNoCoinsFragmentListCoin?.setImageDrawable(drawable)
            binding?.imgNoCoinsFragmentListCoin?.visibility = View.VISIBLE
        } else {
            binding?.rvFragmentListCoin?.adapter = ListCoinAdapter(coins) { coin ->
                goToDetails(coin)
            }
            binding?.imgNoCoinsFragmentListCoin?.visibility = View.GONE
        }

    }

    private fun goToDetails(coin: String) {
        val intent = Intent(activity, CoinDetailsActivity::class.java)
        intent.putExtra("coin", coin)
        startActivity(intent)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}