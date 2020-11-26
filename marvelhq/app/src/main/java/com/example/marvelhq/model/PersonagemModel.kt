package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class PersonagemModel (
    @SerializedName("id")
    val idPersonagem: String,
    @SerializedName("images")
    val img: Int
)