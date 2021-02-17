package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.Provides
import uz.unzosoft.dagger2.di.scope.ActivityScope
import uz.unzosoft.dagger2.model.LocalStorage

@Module
class RepositoryModule {

    @Provides
    fun getLocalStorage(): LocalStorage = LocalStorage()
}