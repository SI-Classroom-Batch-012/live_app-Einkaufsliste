package com.example.einkaufliste

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.einkaufliste.model.Item
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

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
    fun addItem(name: String) {

        val newItem = Item(name)
        val newList = einkaufsListe.value!! + newItem

        postListSorted(newList)

    }

    fun itemChecked(item: Item, checked: Boolean) {

        val newList = einkaufsListe.value!!.toList()
        val index = newList.indexOf(item)
        newList[index].done = checked

        postListSorted(newList)

    }

    private fun postListSorted(newList: List<Item>) {

        val sortedList: List<Item> = newList.sortedBy { it.done }
        _einkaufsListe.postValue(sortedList)

    }

}