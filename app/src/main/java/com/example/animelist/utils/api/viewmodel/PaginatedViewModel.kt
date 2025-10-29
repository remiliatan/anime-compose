package com.example.animelist.utils.api.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class PaginatedViewModel<T>: ViewModel(){
    private val _items = mutableStateOf<List<T>>(emptyList())
    val items: State<List<T>> = _items

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isLoadingMore = mutableStateOf(false)
    val isLoadingMore: State<Boolean> = _isLoadingMore

    private var currentPage = 1
    private var hasNextPage = true
    protected  abstract suspend fun loadPage(page: Int): Pair<List<T>, Boolean>
    fun loadInitial(){
        viewModelScope.launch {
            if(_isLoading.value) return@launch
            _isLoading.value = true
            val(data, hasNext) = loadPage(1)
            _items.value = data
            hasNextPage = hasNext
            currentPage = 1
            _isLoading.value = false
        }
    }

    fun loadMore(){
        viewModelScope.launch {
            if(_isLoadingMore.value || !hasNextPage) return@launch
            _isLoadingMore.value = true
            val (data, hasNext) = loadPage(currentPage + 1)
            _items.value = _items.value + data
            hasNextPage = hasNext
            currentPage += 1
            _isLoadingMore.value = false
        }
    }

}