package com.example.einkaufliste

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.einkaufliste.model.Item

class MainViewModel: ViewModel() {

    //Abschnitt 1: Hintergrunddaten/Testdaten
    val testdata: List<Item> = listOf(
        Item("Milch", false),
        Item("Käse", false),
        Item("Salami", false),
        Item("Brot", true),
        Item("Joghurt", true),
        Item("Salat", false),
    )

    //Abschnitt 2: LiveData
    private val _einkaufsListe: MutableLiveData<List<Item>> = MutableLiveData(testdata)
    val einkaufsListe: LiveData<List<Item>>
        get() = _einkaufsListe



    //Abschnitt 3: Funktionen
    fun addItem(name: String){

        val newItem = Item(name)
        val newList = einkaufsListe.value!! + newItem

        _einkaufsListe.postValue(newList)


    }

    fun itemChecked(item: Item, checked: Boolean) {

        //item enthält eine Referenz zu einem Item aus der LiveData.
        //Deshalb reicht es diese Referenz zu verändern und die Daten werden in der LiveData aktualisiert
        //Zum Überprüfen siehe Log Statements

        Log.d("itemCheckedTest1", einkaufsListe.value!!.toString())

        item.done = checked

        Log.d("itemCheckedTest2", einkaufsListe.value!!.toString())




    }

}