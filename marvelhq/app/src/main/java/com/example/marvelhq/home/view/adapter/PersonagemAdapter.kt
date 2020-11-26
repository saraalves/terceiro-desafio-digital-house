package com.example.marvelhq.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhq.R
import com.example.marvelhq.model.PersonagemModel

class PersonagemAdapter(private val dataSet: MutableList<PersonagemModel>) :
    RecyclerView.Adapter<PersonagemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_home, parent, false)
        return PersonagemViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { item }
    }
}