package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class DatasModel(
    @SerializedName("type")
    val tipo: String,
    @SerializedName("date")
    val data: String
)