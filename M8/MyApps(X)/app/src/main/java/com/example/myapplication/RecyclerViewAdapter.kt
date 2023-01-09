package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(llistat: MutableList<Coche>, context: Context?):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var llistat: MutableList<Coche> = llistat;
    var context: Context? = context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtMarca.setText(llistat.get(position).getMarca());
        holder.txtModelo.setText(llistat.get(position).getModelo());
        holder.txtMotor.setText(llistat.get(position).getMotor());
        holder.txtTraccion.setText(llistat.get(position).getTraccion());
    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtMarca: TextView = view.findViewById(R.id.itemMarca);
        val txtModelo: TextView = view.findViewById(R.id.itemModelo);
        val txtMotor: TextView = view.findViewById(R.id.itemMotor);
        val txtTraccion: TextView = view.findViewById(R.id.itemTraccion);
    }

}