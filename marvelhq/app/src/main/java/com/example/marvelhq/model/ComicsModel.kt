package com.example.marvelhq.model

import com.google.gson.annotations.SerializedName

data class ComicsModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val titulo: String,
    @SerializedName("issueNumber")
    val numeroEdicao: Double,
    @SerializedName("description")
    val descricao: String,
    @SerializedName("pageCount")
    val paginacao: Int,
    @SerializedName("dates")
    val datas: List<DatasModel>,
    @SerializedName("prices")
    val precos: List<PrecosModel>,
    @SerializedName("thumbnail")
    val miniatura: List<MiniaturaModel>,
    @SerializedName("images")
    val imagem: List<ImagemModel>

)