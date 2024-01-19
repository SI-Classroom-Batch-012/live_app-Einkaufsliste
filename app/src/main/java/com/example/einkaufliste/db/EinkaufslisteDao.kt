package com.example.einkaufliste.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.einkaufliste.model.Item

//DAO = Database Access Object -> Datenbankzugriffsobjekt

@Dao
interface EinkaufslisteDao {

    @Query("SELECT * FROM Einkaufsliste")
    fun getItems() : LiveData<List<Item>>

    //Alte Daten behalten
//    @Insert(onConflict = OnConflictStrategy.ABORT)

    //Neuen Daten behalten, alte Daten überschreiben
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

}