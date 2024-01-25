package com.example.coinwise.coin.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coinwise.R
import com.example.coinwise.base.DependencyInjector
import com.example.coinwise.coin.RegisterCoins
import com.example.coinwise.databinding.ActivityMainBinding
import com.example.coinwise.coin.db.Coin
import com.example.coinwise.coin.db.CoinTable
import com.example.coinwise.coin.presentation.CoinPresenter


class MainActivity : AppCompatActivity(), RegisterCoins.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override lateinit var presenter: CoinPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.md_theme_dark_background)
        setFragment()
        setNavigation()

        presenter = CoinPresenter(view = this, repository = DependencyInjector.coinRepository(this))
        presenter.findCoins()

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onGetCoin(l: List<String>) {
        mainViewModel.arrayListLiveData.postValue(l)
    }

    override fun onRestartView() {
        finish()
        startActivity(intent)
    }

    private fun setAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Escolha as moedas")

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
            presenter.updateCoin(CoinTable(id = 1,Coin(listSelected).convertCoinToString()))
        }

        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }

    private fun setDeleteAlertDialog(){
        AlertDialog.Builder(this)
            .setMessage(R.string.delete_message)
            .setNegativeButton(R.string.cancel) { dialog, which ->

            }
            .setPositiveButton(R.string.delete) { dialog, which ->

                presenter.removeCoin(coinId= 1)
            }
            .create()
            .show()
    }

    private fun setFragment(){
        val fragment = ListCoinFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.frame_activity_main, fragment)
            commit()
        }
    }
    private fun setNavigation() {
        binding.toolbarActivityMain.inflateMenu(R.menu.menu_toolbar)

        binding.fabActivityMain.setOnClickListener {
            setAlertDialog()
        }

        binding.toolbarActivityMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.delete -> {
                    setDeleteAlertDialog()
                }
            }
            true
        }
        binding.bottomNavAppBarActivityMain.setOnMenuItemClickListener { item ->

            when (item.itemId) {
                R.id.main -> {
                    goToFragment(ListCoinFragment())
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
            replace(R.id.frame_activity_main, fragment)
            commit()
        }
    }


}