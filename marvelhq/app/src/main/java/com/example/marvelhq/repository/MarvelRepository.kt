package com.example.marvelhq.repository

class MarvelRepository {

    private val client = IMarvelEndpoint.Endpoint

    suspend fun getComics(offset: Int? = 0) = client.getComics(offset)
}