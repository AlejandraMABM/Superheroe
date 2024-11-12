package com.example.superheroe.data

import com.google.gson.annotations.SerializedName

data class SuperheroResponse(
    @SerializedName ("response") val response: String,
    @SerializedName ("result-for") val resultFor: String,
    @SerializedName ("results") val results: List<Superhero>)
{}

data class Superhero(
    @SerializedName ("id") val id:String,
    @SerializedName ("name") val name:String,

)
{}