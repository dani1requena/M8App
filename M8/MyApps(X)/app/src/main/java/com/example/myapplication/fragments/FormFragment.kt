package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.Coche
import com.example.myapplication.DB.CochesDBHelper
import com.example.myapplication.R



/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment(db:CochesDBHelper) : Fragment() {

    var dbHelper:CochesDBHelper=db;

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view: View = inflater.inflate(R.layout.fragment_form, container, false);
        var button: Button = view.findViewById(R.id.buttonSv);
        var marca: EditText = view.findViewById(R.id.marca_input);
        var modelo: EditText = view.findViewById(R.id.modelo_input);
        var motor: EditText = view.findViewById(R.id.motor_input);
        var traccion: EditText = view.findViewById(R.id.traccion_input);

        button.setOnClickListener{
            var c:Coche=Coche(marca.text.toString(), modelo.text.toString(), motor.text.toString(), traccion.text.toString());            dbHelper.insertCoche(c);
        }
        return view;
    }
}
