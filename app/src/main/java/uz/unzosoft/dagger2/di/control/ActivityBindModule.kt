package uz.unzosoft.dagger2.di.control

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.MainActivity
import uz.unzosoft.dagger2.di.module.ApiModule
import uz.unzosoft.dagger2.di.module.MainViewModelModule
import uz.unzosoft.dagger2.di.module.NetworkModule
import uz.unzosoft.dagger2.di.scope.MainScope

@Module
interface ActivityBindModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [
            NetworkModule::class,
            MainViewModelModule::class,
            ApiModule::class
        ]
    )
    fun mainActivity(): MainActivity
}