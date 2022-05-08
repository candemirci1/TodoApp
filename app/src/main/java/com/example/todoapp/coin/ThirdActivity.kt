package com.example.todoapp.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R
import com.example.todoapp.todo.TodoAdapter
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    private lateinit var coinAdapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val coins = getCoins()

        coinAdapter = CoinAdapter(coins)
        rv_coins.adapter = coinAdapter

    }

    private fun getCoins(): List<Coin> {
        return listOf<Coin>(
            Coin("BTC/USDT", 500F, 5, 69000.500, 25.38F),
            Coin("ETH/USDT", 120F, 10, 25000.00, 55.00F),
            Coin("AVAX/USDT", 200F, 15, 500.00, 88.88F),
            Coin("PNG/USDT", 100F, 20, 15.00, -5.95F),
            Coin("RACA/USDT", 500F, 20, 1.00, 25.38F)
        )

    }
}