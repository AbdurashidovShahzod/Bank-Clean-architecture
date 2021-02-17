package uz.unzosoft.dagger2

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uz.unzosoft.dagger2.di.component.DaggerAppComponent

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}