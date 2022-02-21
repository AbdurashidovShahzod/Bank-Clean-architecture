package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.MainActivity
import uz.unzosoft.dagger2.di.scope.MainScope
import javax.inject.Scope

@Module
interface ActivityModule {
    @MainScope
    @ContributesAndroidInjector(
        modules = []
    )
    fun mainActivity(): MainActivity

}