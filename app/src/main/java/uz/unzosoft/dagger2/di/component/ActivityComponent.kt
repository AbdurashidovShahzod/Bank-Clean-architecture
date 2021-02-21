package uz.unzosoft.dagger2.di.component

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import uz.unzosoft.dagger2.di.module.ActivityModule
import uz.unzosoft.dagger2.di.module.NetworkModule
import uz.unzosoft.dagger2.di.module.RepositoryModule
import javax.inject.Singleton


@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityModule::class]
)
@Singleton
class ActivityComponent {
}