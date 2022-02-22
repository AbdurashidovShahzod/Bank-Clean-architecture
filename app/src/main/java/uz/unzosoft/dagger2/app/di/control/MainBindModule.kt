package uz.unzosoft.dagger2.app.di.control

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.app.di.main.MainViewModelModule
import uz.unzosoft.dagger2.app.di.main.ScreenBuildModule
import uz.unzosoft.dagger2.app.di.module.*
import uz.unzosoft.dagger2.app.di.scope.MainScope
import uz.unzosoft.dagger2.app.ui.activity.MainActivity

@Module
interface MainBindModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [
            MainViewModelModule::class,
            ScreenBuildModule::class,
            NetworkModule::class,
            ApiModule::class,
            DataSourceModule::class,
            RepositoryModule::class,
            UseCaseModule::class
        ]
    )
    fun mainActivity(): MainActivity
}