package com.example.todoapp.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityThirdBinding
import com.example.todoapp.helper.DataHelper


class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    private lateinit var coinAdapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHelper = DataHelper()
        val coins = dataHelper.getCoins()


        coinAdapter = CoinAdapter(coins)
        binding.rvCoins.adapter = coinAdapter

    }


}