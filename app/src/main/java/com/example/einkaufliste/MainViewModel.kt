package com.example.einkaufliste

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.einkaufliste.db.Repository
import com.example.einkaufliste.db.databaseManagementObject
import com.example.einkaufliste.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //Abschnitt 1: Hintergrunddaten/Testdaten

    val repository = Repository(databaseManagementObject.getDatabase(application))


    //Abschnitt 2: LiveData
    val einkaufsListe: LiveData<List<Item>> = repository.allItems



    //Abschnitt 3: Funktionen

    fun insertItem(itemName: String){
        viewModelScope.launch(Dispatchers.IO) {

            val newItem = Item(name = itemName)
            repository.insertItem(newItem)

        }


    }







//    fun addItem(name: String) {
//
//        val newItem: Item = Item(name)
//        val newList = listOf(newItem) + einkaufsListe.value!! //: List<Item>
//
//        postListSorted(newList)
//
//    }
//
//    fun itemChecked(item: Item, checked: Boolean) {
//
//        val newList = einkaufsListe.value!!.toList()
//        val index = newList.indexOf(item)
//        newList[index].done = checked
//
//        postListSorted(newList)
//
//    }
//
//    private fun postListSorted(newList: List<Item>) {
//
//        val sortedList: List<Item> = newList.sortedBy { it.done }
//        _einkaufsListe.postValue(sortedList)
//
//    }

}