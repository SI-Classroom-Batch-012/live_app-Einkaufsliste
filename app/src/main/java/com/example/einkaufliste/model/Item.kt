package com.example.einkaufliste.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Einkaufsliste")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    var done: Boolean = false,
)
