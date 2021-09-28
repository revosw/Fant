package ntnu.simenwii.fant.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoginService {
    @GET("auth/login")
    suspend fun login(
        @Header("Authorization")
        @Query("uid") username: String,
        @Query("pwd") password: String
    )

    @GET("auth/currentuser")
    suspend fun getUser(
        @Header("Authorization")
        @Query("uid") username: String,
        @Query("pwd") password: String
    )
}