package com.example.todoapp.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalAdapter(
    private val animals: MutableList<Animal>
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_animal, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        var curAnimal = animals[position]
        holder.itemView.apply {
            tv_animal_name.text = curAnimal.name
            tv_animal_leg.text = curAnimal.legCount.toString()
            if(curAnimal.isFavorite) {
                iv_star.visibility = View.VISIBLE
            } else {
                iv_star.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }

}

