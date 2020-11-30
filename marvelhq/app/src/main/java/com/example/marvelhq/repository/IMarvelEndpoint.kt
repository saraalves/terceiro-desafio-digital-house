package com.example.marvelhq.repository

import com.example.marvelhq.model.ComicsModel
import com.example.marvelhq.model.ResponseModel
import com.example.marvelhq.netwok.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarvelEndpoint {
    @GET("/v1/public/comics")
    suspend fun getComics(@Query("offset") offset: Int? = 0): ResponseModel<ComicsModel>

    companion object {
        val Endpoint: IMarvelEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IMarvelEndpoint::class.java)
        }
    }
}