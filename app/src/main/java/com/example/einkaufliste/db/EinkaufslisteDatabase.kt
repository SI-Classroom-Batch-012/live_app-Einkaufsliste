package com.example.einkaufliste.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.einkaufliste.model.Item

@Database(entities = [Item::class], version = 1)
abstract class EinkaufslisteDatabase : RoomDatabase() {
    abstract val dao: EinkaufslisteDao
}

object databaseManagementObject {

    private lateinit var INSTANCE: EinkaufslisteDatabase

    fun getDatabase(context: Context): EinkaufslisteDatabase {

        synchronized(EinkaufslisteDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    EinkaufslisteDatabase::class.java,
                    "el_database"
                ).build()
            }
            return INSTANCE
        }
    }
}


