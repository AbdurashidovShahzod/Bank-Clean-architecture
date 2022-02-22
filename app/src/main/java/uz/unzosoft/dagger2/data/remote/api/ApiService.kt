package uz.unzosoft.dagger2.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.unzosoft.dagger2.data.model.RepositoryResponse


/**
 * Created by Abdurashidov Shahzod on
 * company QQBank
 * shahzod9933@gmail.com
 */
interface ApiService {

    @GET("repositories")
    suspend fun getRepository(@Query("q") search: String): Response<RepositoryResponse>
}