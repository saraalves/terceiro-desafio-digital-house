package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class ImagemModel(
    @SerializedName("path")
    val pathImagem: String,
    @SerializedName("extension")
    val extensaoImagem: String
)
