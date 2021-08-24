package com.chloetseng.zoo.exhibit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.databinding.ItemExhibitPlantBinding

class ExhibitAdapter(val viewModel: ExhibitViewModel): ListAdapter<Plant, ExhibitAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ItemExhibitPlantBinding, private val viewModel: ExhibitViewModel):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plant: Plant) {
            binding.item = plant
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(ItemExhibitPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false),viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(plant)
    }

}