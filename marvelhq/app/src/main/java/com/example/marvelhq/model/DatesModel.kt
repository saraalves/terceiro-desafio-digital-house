package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class DatesModel(
    @SerializedName("type")
    val tipo: String,
    @SerializedName("date")
    val data: String
)