package uz.unzosoft.dagger2.app.di.control

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.app.di.main.MainViewModelModule
import uz.unzosoft.dagger2.app.di.main.ScreenBuildModule
import uz.unzosoft.dagger2.app.di.module.ApiModule
import uz.unzosoft.dagger2.app.di.module.NetworkModule
import uz.unzosoft.dagger2.app.di.module.RepositoryModule
import uz.unzosoft.dagger2.app.di.scope.MainScope
import uz.unzosoft.dagger2.app.ui.activity.MainActivity

@Module
interface ActivityBindModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [
            MainViewModelModule::class,
            ScreenBuildModule::class,
            NetworkModule::class,
            ApiModule::class,
            RepositoryModule::class
        ]
    )
    fun mainActivity(): MainActivity
}