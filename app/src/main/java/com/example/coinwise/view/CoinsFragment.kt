package com.example.coinwise.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinwise.R
import com.example.coinwise.databinding.FragmentCoinsBinding

class CoinsFragment : Fragment(R.layout.fragment_coins) {
    private var binding: FragmentCoinsBinding? = null
    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCoinsBinding.bind(view)
        binding?.mainRecyclerview?.layoutManager = LinearLayoutManager(context)
        binding?.mainRecyclerview?.adapter = ListCoinAdapter(listOf("oi", "test")) {coin->
            goToDetails(coin)

        }



        activity?.let {
            mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        }

        mainViewModel.arrayListLiveData.observe(viewLifecycleOwner) { arrayList ->
            binding?.mainRecyclerview?.adapter = ListCoinAdapter(arrayList){coin->
                goToDetails(coin)
            }
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