package com.example.coinwise.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coinwise.R
import com.example.coinwise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.md_theme_dark_background)

        val fragment = CoinsFragment()

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
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose some animals")

        val coins = arrayOf("ADA", "BNB", "BTC", "DOGE", "ETH", "USDT", "XRP")
        val checkedItems = booleanArrayOf(true, false, true, false, false, true, false)

        builder.setMultiChoiceItems(coins, checkedItems) { dialog, which, isChecked ->
            checkedItems[which] = isChecked

        }

        builder.setPositiveButton("OK") { dialog, which ->
            //TODO Chamar presenter para bater na api
            val listSelected = ArrayList<String>()

            for (i in checkedItems.indices) {
                val checked = checkedItems[i]
                if (checked) {
                    listSelected.add(coins[i])
                }
                mainViewModel.arrayListLiveData.postValue(listSelected)
            }
        }

        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }


}