package uz.unzosoft.dagger2.app.ui.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.collect
import uz.unzosoft.dagger2.app.di.module.StorageMain
import uz.unzosoft.dagger2.app.ui.base.BaseViewModel
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.usecase.RepositoryUseCase
import uz.unzosoft.dagger2.domain.util.ResourceUI
import javax.inject.Inject


class HomeScreenViewModel @Inject constructor(
    private val storageMain: StorageMain,
    private val useCase: RepositoryUseCase
) : BaseViewModel() {

    private val _homeLiveData = MutableLiveData<String>()
    val homeLiveData: LiveData<String> get() = _homeLiveData

    private val _repositoryLiveData = MutableLiveData<RepositoryDto>()
    val repositoryLiveData: LiveData<RepositoryDto> get() = _repositoryLiveData

     fun searchRepository(search: String) {
        launchVM {
            _loadingLiveData.value = Unit
            useCase.invoke(search).collect {
                when (it) {
                    is ResourceUI.Error -> {
                        Log.d("Zarnigor", "${it.error.message}")
                    }
                    is ResourceUI.Resource -> {
                        val data = it.data
                        Log.d("Zarnigor", "${data.items.toString()}")
                        _repositoryLiveData.value = data
                    }
                }
            }
        }
    }
}