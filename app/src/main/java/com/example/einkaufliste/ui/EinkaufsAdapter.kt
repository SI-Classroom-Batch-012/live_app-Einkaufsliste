package com.example.einkaufliste.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.einkaufliste.MainViewModel
import com.example.einkaufliste.databinding.ListItemBinding
import com.example.einkaufliste.misc.ItemDiffUtil
import com.example.einkaufliste.model.Item


class EinkaufsAdapter(
    private val viewmodel: MainViewModel
) : ListAdapter<Item, EinkaufsAdapter.ItemViewHolder>(ItemDiffUtil()) {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = currentList[position]

        holder.binding.itemTV.text = item.name

        holder.binding.itemCB.isChecked = item.done

        Log.d("transparency_test1", "${item.done}")



        holder.binding.itemCB.setOnClickListener {

            val isChecked = holder.binding.itemCB.isChecked

            viewmodel.itemChecked(item, isChecked)

            Log.d("transparency_test2", "${item.done}")
            if (item.done) {
                holder.binding.itemCL.alpha = 0.5f
            } else {
                holder.binding.itemCL.alpha = 1f
            }

        }


    }
}