package com.example.todoapp.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.coin.ThirdActivity
import com.example.todoapp.databinding.ActivitySecondBinding
import com.example.todoapp.helper.DataHelper

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var animalAdapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnThird.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }
        }

        val animalList = DataHelper().getAnimals()


        animalAdapter = AnimalAdapter(animalList)
        binding.rvAnimals.adapter = animalAdapter

    }
}