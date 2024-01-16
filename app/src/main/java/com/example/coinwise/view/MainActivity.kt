package com.example.coinwise.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coinwise.R
import com.example.coinwise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.md_theme_dark_background)

        var fragment = CoinsFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frame_activity_home, fragment)
            commit()
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.fabActivityHome.setOnClickListener {
            setAlertDialog()
        }


    }

    private fun setAlertDialog() {
        // Set up the alert builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose some animals")

        // Add a checkbox list
        val coins = arrayOf("ADA", "BNB", "BTC", "DOGE", "ETH", "USDT", "XRP")
        val checkedItems = booleanArrayOf(true, false, true, false, false, true, false)

        val coinsList = listOf(*coins)
        builder.setMultiChoiceItems(coins, checkedItems) { dialog, which, isChecked ->
            checkedItems[which] = isChecked
            val currentItem = coinsList[which]

        }

        // Add OK and Cancel buttons
        builder.setPositiveButton("OK") { dialog, which ->
            //TODO Chamar presenter para bater na api
            mainViewModel.arrayListLiveData.postValue(coinsList)

        }
        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }


}