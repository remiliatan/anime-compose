package com.example.animelist.utils.api.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelist.model.AnimeModel
import com.example.animelist.model.AnimePage
import com.example.animelist.utils.api.ApiClient
import com.example.animelist.utils.api.interfaceapi.GraphQLRequest
import com.example.animelist.utils.api.query.AnimeQuery
import com.google.gson.Gson
import kotlinx.coroutines.launch

class AnimeViewModel: ViewModel(){
    private val _animes = mutableStateOf<List<AnimeModel>>(emptyList())
    val animes: State<List<AnimeModel>> = _animes
    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    init {
        fetchAnimes()
    }

    private fun fetchAnimes(){
        viewModelScope.launch {
            try {
                val variables = mapOf(
                    "page" to 1
                )

                val body = GraphQLRequest(AnimeQuery.getAnimes, variables)
                _isLoading.value = true

                val result = ApiClient.instance.queryGraphQl(body)
                if (!result.isSuccessful) {
                    throw Exception(result.errorBody().toString())
                }

                val response = result.body()?.data?.get("Page")
                val gson = Gson()
                val mediaJson = gson.toJson(response)
                val animeMedia = gson.fromJson(mediaJson.toString(), AnimePage::class.java)
                _animes.value = animeMedia.media

            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _isLoading.value = false
            }
        }
    }

}