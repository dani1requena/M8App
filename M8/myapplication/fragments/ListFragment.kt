package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DB.CochesDBHelper
import com.example.myapplication.R
import com.example.myapplication.RecyclerViewAdapter


class ListFragment(dbHelper: CochesDBHelper) : Fragment() {
    // TODO: Rename and change types of parameters
    private var db:CochesDBHelper = dbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val llistat= db.getAllCoches()

        val v =  inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView: RecyclerView = v.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter= RecyclerViewAdapter(llistat, context)
        recyclerView.adapter = adapter
        return v
    }
}