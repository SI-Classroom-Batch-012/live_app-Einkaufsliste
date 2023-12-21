package com.example.einkaufliste.misc

import androidx.recyclerview.widget.DiffUtil
import com.example.einkaufliste.model.Item

class ItemDiffUtil: DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name && oldItem.done == newItem.done
    }
}