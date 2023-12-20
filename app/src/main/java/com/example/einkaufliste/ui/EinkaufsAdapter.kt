package com.example.einkaufliste.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.einkaufliste.MainViewModel
import com.example.einkaufliste.databinding.ListItemBinding
import com.example.einkaufliste.model.Item

class EinkaufsAdapter(
    var dataset: List<Item>,
    val viewmodel: MainViewModel
) : RecyclerView.Adapter<EinkaufsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        holder.binding.itemTV.text = item.name
        holder.binding.itemCB.isChecked = item.done

        holder.binding.itemCB.setOnCheckedChangeListener { _, isChecked ->

            viewmodel.itemChecked(item, isChecked)

        }

    }
}