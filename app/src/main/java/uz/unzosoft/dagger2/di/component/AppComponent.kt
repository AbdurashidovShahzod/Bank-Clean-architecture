package uz.unzosoft.dagger2.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.unzosoft.dagger2.App
import uz.unzosoft.dagger2.di.module.ActivityModule
import uz.unzosoft.dagger2.di.module.NetworkModule
import uz.unzosoft.dagger2.di.module.RepositoryModule
import uz.unzosoft.dagger2.model.LocalStorage
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance context: Context): AppComponent
    }
}