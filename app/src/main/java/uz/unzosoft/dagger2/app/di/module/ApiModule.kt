package uz.unzosoft.dagger2.app.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.unzosoft.dagger2.data.remote.api.ApiService

@Module
class ApiModule {
    @Provides
    fun get(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}