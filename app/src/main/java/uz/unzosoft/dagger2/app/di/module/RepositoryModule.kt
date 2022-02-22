package uz.unzosoft.dagger2.app.di.module

import dagger.Module
import dagger.Provides
import uz.unzosoft.dagger2.app.model.LocalStorage

@Module
class RepositoryModule {

    @Provides
    fun getLocalStorage(): LocalStorage = LocalStorage()
}