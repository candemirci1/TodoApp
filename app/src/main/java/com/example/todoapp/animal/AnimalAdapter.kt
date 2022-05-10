package com.example.todoapp.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemAnimalBinding



class AnimalAdapter(
    private val animals: MutableList<Animal>
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        var curAnimal = animals[position]
        holder.binding.apply {
            tvAnimalName.text = curAnimal.name
            tvAnimalLeg.text = curAnimal.legCount.toString()
            if(curAnimal.isFavorite) {
                ivStar.visibility = View.VISIBLE
            } else {
                ivStar.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }

}

