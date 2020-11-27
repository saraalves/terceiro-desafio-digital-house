package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class MiniaturaModel (
    @SerializedName("path")
    val pathMini: String,
    @SerializedName("extension")
    val extensaoMini: String
)
