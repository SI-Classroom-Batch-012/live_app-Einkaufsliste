package com.example.einkaufliste.db

import com.example.einkaufliste.model.Item

class Repository(val database: EinkaufslisteDatabase) {

    val allItems = database.dao.getItems()


    suspend fun insertItem(item: Item){

        database.dao.insertItem(item)

    }



}