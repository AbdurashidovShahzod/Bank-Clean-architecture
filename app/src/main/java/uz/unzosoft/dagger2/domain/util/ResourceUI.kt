package uz.unzosoft.dagger2.domain.util

@DslMarker
annotation class ResourceDSL

@ResourceDSL
sealed class ResourceUI<out T> {
    data class Resource<T>(val data: T, val statusCode: Int = 200) : ResourceUI<T>()
    data class Error(val error: Throwable) : ResourceUI<Nothing>()
}