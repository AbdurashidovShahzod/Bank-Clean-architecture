package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.unzosoft.dagger2.di.scope.ActivityScope
import uz.unzosoft.dagger2.model.AuthApi

@Module
class ApiModule {
    @Provides
    fun getAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
}