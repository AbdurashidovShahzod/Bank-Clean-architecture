package uz.unzosoft.dagger2.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.MainActivity

@Module
interface ActivityModule {
    @ContributesAndroidInjector(
        modules = []
    )
    fun mainActivity(): MainActivity
}