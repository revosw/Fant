package ntnu.simenwii.fant.network

import ntnu.simenwii.fant.network.response.SellableSearchResponse
import retrofit2.http.*

interface SellableService {
    @GET("fant")
    suspend fun getAll(
        @Header("Authorization") token: String
    ): SellableSearchResponse

    @DELETE("fant")
    suspend fun delete(
        @Header("Authorization") token: String
    ): SellableSearchResponse

    @PUT("fant/buy/{id}")
    suspend fun buy(
        @Header("Authorization") token: String
    ): SellableSearchResponse

    @POST("fant/create")
    suspend fun create(
        @Header("Authorization") token: String
    ): SellableSearchResponse

    @GET("fant/photo/{name}")
    suspend fun getPhoto(
        @Header("Authorization") token: String
    ): SellableSearchResponse
}