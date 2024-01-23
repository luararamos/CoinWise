package com.example.coinwise.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coinwise.R
import com.example.coinwise.base.DependencyInjector
import com.example.coinwise.databinding.ActivityMainBinding
import com.example.coinwise.db.Coin
import com.example.coinwise.db.CoinTable
import com.example.coinwise.presentation.MainPresenter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.md_theme_dark_background)

        val fragment = CoinsListFragment()
        presenter = MainPresenter(DependencyInjector.coinRepository(this))

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frame_activity_home, fragment)
            commit()
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.fabActivityHome.setOnClickListener {
            setAlertDialog()
        }
        setNavigation()

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
            }
            mainViewModel.arrayListLiveData.postValue(listSelected)
            presenter.addCoin(CoinTable(Coin(listSelected)))
        }

        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }

    private fun setNavigation() {
        binding.bottomNavAppBarActivityHome.setOnMenuItemClickListener { item ->

            when (item.itemId) {
                R.id.main -> {
                    goToFragment(CoinsListFragment())
                    true
                }

                R.id.information -> {
                    goToFragment(CurrencyInformationFragment())
                    true
                }

                R.id.about -> {
                    goToFragment(AboutFragment())
                    true
                }

                else -> true
            }
        }
    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_activity_home, fragment)
            commit()
        }
    }


}