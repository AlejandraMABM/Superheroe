package com.example.superheroe.services

import com.example.superheroe.data.Superhero
import com.example.superheroe.data.SuperheroResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {

    @GET ("search/{name}")
    suspend fun findSuperheroesByName(@Path("name") query: String) : SuperheroResponse

    @GET ("{character-id}")
    suspend fun findSuperheroesById(@Path("character-id") id: String) : Superhero



}