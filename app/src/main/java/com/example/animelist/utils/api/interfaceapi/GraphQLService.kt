package com.example.animelist.utils.api.interfaceapi

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class GraphQLRequest(
    val query: String,
    val variables: Map<String, Any?> = emptyMap()
)

data class GraphQLResponse(
    val data: Map<String, Any>?,
    val errors: List<Map<String, Any>>? = null
)
interface GraphQLService {
    @POST("/")
    @Headers("Content-Type: application/json")
    suspend fun queryGraphQl(
        @Body request: GraphQLRequest
    ): Response<GraphQLResponse>
}