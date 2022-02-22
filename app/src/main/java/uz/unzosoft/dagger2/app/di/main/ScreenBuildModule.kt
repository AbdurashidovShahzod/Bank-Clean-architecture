package uz.unzosoft.dagger2.app.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.unzosoft.dagger2.app.ui.screens.home.HomeScreen

@Module
interface ScreenBuildModule {

    @ContributesAndroidInjector
    fun cHomeScreen(): HomeScreen


}