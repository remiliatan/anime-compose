package com.example.animelist.model

import androidx.compose.runtime.Immutable

@Immutable
data class AnimeModel (
    val id: Int,
    val idMal: Int?,
    val title: AnimeTitle?,
    val bannerImage: String?,
    val coverImage: AnimeCover?
)
@Immutable
data class AnimeTitle (
    val romaji: String?,
    val native: String? ,
    val english: String?
)

data class AnimeCover (
    val medium: String?,
    val large: String?,
    val extraLarge: String?
)

@Immutable
data class AnimePage(
    val pageInfo: Page,
    val media: List<AnimeModel>
)