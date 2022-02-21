package uz.unzosoft.dagger2.di.control

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import uz.unzosoft.dagger2.ui.utils.ViewModelProvideFactory

@Module
abstract class ViewModuleFactoryModule {

    @Binds
    abstract fun bideViewModuleFactory(viewModelProvideFactory: ViewModelProvideFactory): ViewModelProvider.Factory
}