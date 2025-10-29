package com.example.animelist.utils.api

import com.example.animelist.utils.api.interfaceapi.GraphQLService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val instance: GraphQLService by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GraphQLService::class.java)
    }
}