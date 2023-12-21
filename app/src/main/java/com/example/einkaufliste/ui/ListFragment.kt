package com.example.einkaufliste.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.einkaufliste.MainViewModel
import com.example.einkaufliste.R
import com.example.einkaufliste.databinding.FragmentListBinding
import com.example.einkaufliste.model.Item


class ListFragment : Fragment() {

    private val viewmodel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //Abschnitt 1: Setup und Initialisierung

        val adapter = EinkaufsAdapter(viewmodel)
        binding.einkauflisteRV.adapter = adapter



        //Abschnitt 2: Observer
        viewmodel.einkaufsListe.observe(viewLifecycleOwner){
            //Lade neue Daten in alten Adapter

            adapter.submitList(it)

        }


        //Abschnitt 3: UI Events/Listener

        binding.addFAB.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(requireContext())

            val nameET = EditText(requireContext())
            dialogBuilder.setView(nameET)

            dialogBuilder.setPositiveButton("Bestätigen") { _, _ ->

                val name = nameET.text.toString()
                viewmodel.addItem(name)

            }

            dialogBuilder.setNegativeButton("Abbrechen") { _, _ ->

            }

            dialogBuilder.show()

        }

    }
}