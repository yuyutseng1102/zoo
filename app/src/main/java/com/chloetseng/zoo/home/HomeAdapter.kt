package com.chloetseng.zoo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.databinding.ItemHomeExhibitBinding

class HomeAdapter(val viewModel: HomeViewModel): ListAdapter<Exhibit, HomeAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ItemHomeExhibitBinding,private val viewModel: HomeViewModel):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exhibit: Exhibit) {
            binding.item = exhibit
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Exhibit>() {
        override fun areItemsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeExhibitBinding.inflate(LayoutInflater.from(parent.context), parent, false),viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exhibit = getItem(position)
        holder.bind(exhibit)
    }

}