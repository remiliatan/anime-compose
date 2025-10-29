package com.example.animelist.utils.api.query

object AnimeQuery {
    val getAnimes = """
        query (${"$"}id: Int, ${"$"}page: Int, ${"$"}perPage: Int, ${"$"}search: String) {
          Page (page: ${"$"}page, perPage: ${"$"}perPage) {
            pageInfo {
              currentPage
              hasNextPage
              perPage
            }
            media (id: ${"$"}id, search: ${"$"}search, type: ANIME) {
              id
              idMal
              title {
                romaji
                native
                english
              }
              bannerImage
              coverImage {
                medium
                large
                extraLarge
              }
            }
          }
        }
""".trimIndent()
}