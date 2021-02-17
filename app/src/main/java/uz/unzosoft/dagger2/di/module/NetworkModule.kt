package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.unzosoft.dagger2.di.scope.ActivityScope
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/weather?q=karachi&appid=462f445106adc1d21494341838c10019")
        .build()

}