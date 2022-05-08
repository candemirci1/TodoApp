package com.example.todoapp.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R
import com.example.todoapp.coin.ThirdActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var animalAdapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn_third.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }
        }

        val animals = mutableListOf<Animal>(
            Animal("Dog", 4, true),
            Animal("Duck", 2, true),
            Animal("snake", 0, false),
            Animal("bird", 2, false)
        )


        animalAdapter = AnimalAdapter(animals)
        rv_animals.adapter = animalAdapter

    }
}