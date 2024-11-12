package com.example.superheroe.utils

import com.example.superheroe.data.tokenSuperHeroe
import com.example.superheroe.services.SuperheroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    companion object {
        fun getRetrofit() : SuperheroService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://superheroapi.com/api/${tokenSuperHeroe}/")
                    .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(SuperheroService::class.java)
        }
    }
}