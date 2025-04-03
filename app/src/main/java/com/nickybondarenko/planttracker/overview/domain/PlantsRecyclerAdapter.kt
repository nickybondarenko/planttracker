package com.nickybondarenko.planttracker.overview.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nickybondarenko.planttracker.databinding.ViewHolderPlantItemBinding

class PlantsRecyclerAdapter(
    private val plants: List<Plant>
) :RecyclerView.Adapter<PlantsRecyclerAdapter.PlantsViewHolder>() {

    inner class PlantsViewHolder(val binding: ViewHolderPlantItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        return PlantsViewHolder(ViewHolderPlantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        holder.binding.apply {
            plantName.text = plants[position].name
            plantDescription.text = plants[position].description
        }
    }
}