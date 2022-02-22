package uz.unzosoft.dagger2.app.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.unzosoft.dagger2.app.di.control.ServiceQualifier
import uz.unzosoft.dagger2.app.ui.utils.Config.BASE_URL
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun retrofit(): String =BASE_URL

    @Provides
    @ServiceQualifier
    fun provideRetrofitInstance(
        //okhttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        baseUrl:String
    ): Retrofit {
        return Retrofit.Builder()
            //.client(okhttpClient)
//            .baseUrl(BASE_URL_TEST)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(gsonConverterFactory)
//            .addConverterFactory(provideFactory())
            .build()
    }

    @Provides
    fun gson(): Gson {
        return GsonBuilder().create()
    }


    @Provides
    fun gsonConvertFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }


    @Provides
    fun cache(file: File): Cache {
        return Cache(file, 20 * 100 * 100)//(20)MB
    }


}