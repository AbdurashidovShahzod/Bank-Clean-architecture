package uz.unzosoft.dagger2.app.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.unzosoft.dagger2.app.di.module.StorageMain
import uz.unzosoft.dagger2.app.ui.base.BaseViewModel
import javax.inject.Inject


class HomeScreenViewModel @Inject constructor(
    private val storageMain: StorageMain
) : BaseViewModel() {
    private val _homeLiveData = MutableLiveData<String>()
    val homeLiveData:LiveData<String> get() = _homeLiveData

    init {
        setUpHome()
    }

    private fun setUpHome(){
        launchVM {
            _homeLiveData.value = storageMain.roomStorageMain
        }
    }
}