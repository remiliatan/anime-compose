package com.example.animelist.utils.api.viewmodel

import com.example.animelist.model.AnimeModel
import com.example.animelist.model.AnimePage
import com.example.animelist.utils.api.ApiClient
import com.example.animelist.utils.api.interfaceapi.GraphQLRequest
import com.example.animelist.utils.api.query.AnimeQuery
import com.google.gson.Gson

class AnimeViewModel: PaginatedViewModel<AnimeModel>(){
    init {
        loadInitial()
    }

    override suspend fun loadPage(page: Int): Pair<List<AnimeModel>, Boolean> {
        val variables = mapOf(
            "page" to page
        )
        val body = GraphQLRequest(AnimeQuery.getAnimes, variables)

        val result = ApiClient.instance.queryGraphQl(body)
        if (!result.isSuccessful) {
            throw Exception(result.errorBody().toString())
        }

        val response = result.body()?.data?.get("Page")
        val gson = Gson()
        val mediaJson = gson.toJson(response)
        val animeMedia = gson.fromJson(mediaJson.toString(), AnimePage::class.java)
        return animeMedia.media to animeMedia.pageInfo.hasNextPage
    }

}