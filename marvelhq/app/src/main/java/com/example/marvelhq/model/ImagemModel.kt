package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class ImagemModel(
    @SerializedName("path")
    val pathImagem: String,
    @SerializedName("extension")
    val extensaoImagem: String
) {
    fun getImagePath(imageResolution: String? = "detail"): String {
        return "$pathImagem/$imageResolution.$extensaoImagem".replace("http://", "https://")
    }
}

