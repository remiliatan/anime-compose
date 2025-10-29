package com.example.animelist.model

import androidx.compose.runtime.Immutable

@Immutable
data class Page(
    val currentPage: String,
    val hasNextPage: Boolean,
    val perPage: String
)

//@Immutable
//data class PageModel(
//    val pageInfo: Page,
//    val media: List<listModel>
//)