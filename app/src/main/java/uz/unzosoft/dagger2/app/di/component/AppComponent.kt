package uz.unzosoft.dagger2.app.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.unzosoft.dagger2.app.ui.app.App
import uz.unzosoft.dagger2.app.di.control.MainBindModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainBindModule::class,

    ]
)

@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
