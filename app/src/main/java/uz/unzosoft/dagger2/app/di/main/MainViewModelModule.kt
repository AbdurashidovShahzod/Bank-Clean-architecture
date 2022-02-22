package uz.unzosoft.dagger2.app.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.unzosoft.dagger2.app.di.control.ViewModelKey
import uz.unzosoft.dagger2.app.ui.screens.home.HomeScreenViewModel

@Module
interface MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel::class)
    fun bMainViewModel(viewModel: HomeScreenViewModel): ViewModel



}
