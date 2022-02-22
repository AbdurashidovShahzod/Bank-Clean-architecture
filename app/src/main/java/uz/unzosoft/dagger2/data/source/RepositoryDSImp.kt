package uz.unzosoft.dagger2.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import uz.unzosoft.dagger2.data.model.RepositoryResponse
import uz.unzosoft.dagger2.data.remote.api.ApiService
import uz.unzosoft.dagger2.data.util.*
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.source.RepositoryDS
import uz.unzosoft.dagger2.domain.util.ResourceUI
import java.lang.Exception
import javax.inject.Inject

class RepositoryDSImp @Inject constructor(
    private val apiService: ApiService
) : RepositoryDS {

    private fun handleError(body: ResponseBody?): String {
        body?.toString()
        val tempError = """{ "errorMessage" = "Some Error from network" }"""
        val byteArray: ByteArray = body?.bytes() ?: tempError.toByteArray()
        return try {
            JSONObject(String(byteArray)).getString("errorMessage")
        } catch (e: JSONException) {
            e.message.toString()
        }
    }

    override suspend fun repository(search: String): Flow<ResourceUI<RepositoryDto>> {
        return flow {
            val data = try {
                val response: Response<RepositoryResponse> = apiService.getRepository(search)
                val d = response.body()
                when (response.code()) {
                    in 200..299 -> {
                        if (d != null) ResourceUI.Resource(d, response.code())
                        else ResourceUI.Error(NullPointerException("Response data must not be null"))
                    }
                    401 -> {
                        ResourceUI.Error(TokenWrongException(""))
                    }
                    428 -> {
                        val message: String = handleError(response.errorBody())
                        ResourceUI.Error(GlobalException(message, response.code()))
                    }
                    426 -> {
                        val message: String = handleError(response.errorBody())
                        ResourceUI.Error(AppUpdateException(message))
                    }
                    422 -> {
                        val message: String = handleError(response.errorBody())
                        ResourceUI.Error(InfoForUser(message))
                    }
                    else -> {
                        val message: String = handleError(response.errorBody())
                        ResourceUI.Error(NetworkException(message))
                    }
                }
            } catch (e: Exception) {
                when (e) {
                    else -> ResourceUI.Error(e)
                }
            }

            when (data) {
                is ResourceUI.Error -> {
                    emit(data)
                }
                is ResourceUI.Resource -> {
                    val view = data.data
                    emit(ResourceUI.Resource(view.toDto()))
                }
            }
        }
    }
}