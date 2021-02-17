package uz.unzosoft.dagger2.model

import dagger.Module
import retrofit2.http.GET


interface AuthApi {
    @GET("/data")
    fun getInfo(): String
}