package com.example.todoapp.helper

import com.example.todoapp.animal.Animal
import com.example.todoapp.coin.Coin

class DataHelper {
    fun getCoins(): List<Coin> {
        return listOf<Coin>(
            Coin("BTC/USDT", 500F, 5, 69000.500, 25.38F),
            Coin("ETH/USDT", 120F, 10, 25000.00, 55.00F),
            Coin("AVAX/USDT", 200F, 15, 500.00, 88.88F),
            Coin("PNG/USDT", 100F, 20, 15.00, -5.95F),
            Coin("RACA/USDT", 500F, 20, 1.00, 25.38F)
        )

    }
    fun getAnimals(): MutableList<Animal> {

        return mutableListOf(
            Animal("Dog", 4, true),
            Animal("Duck", 2, true),
            Animal("snake", 0, false),
            Animal("bird", 2, false)
        )
    }


}
