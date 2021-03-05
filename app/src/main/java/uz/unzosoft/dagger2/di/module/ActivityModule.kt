package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.MainActivity
import uz.unzosoft.dagger2.di.scope.ActivityScope
import javax.inject.Scope

@Module
interface ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = []
    )
    fun mainActivity(): MainActivity

}