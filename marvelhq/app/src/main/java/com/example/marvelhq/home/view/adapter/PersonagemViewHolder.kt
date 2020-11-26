package com.example.marvelhq.home.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhq.R
import com.example.marvelhq.model.PersonagemModel
import com.squareup.picasso.Picasso

class PersonagemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val imagem = view.findViewById<ImageView>(R.id.imagePersonagem)
    private val idPersonagem = view.findViewById<TextView>(R.id.txtPersonagem)

    fun bind(personagemModel: PersonagemModel) {
        idPersonagem.text = personagemModel.idPersonagem

        Picasso.get()
            .load(personagemModel.img)
            .into(imagem)
    }
}