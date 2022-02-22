package uz.unzosoft.dagger2.app.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import uz.unzosoft.dagger2.app.ui.utils.SingleLiveEvent
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel() {
    protected val TAG = "TAG"
    private val _globalErrorLiveData = SingleLiveEvent<String>()
    val globalErrorLiveData: LiveData<String> = _globalErrorLiveData


    protected val _loadingLiveData = MutableLiveData<Unit>()
    val loadingLiveData: LiveData<Unit> = _loadingLiveData

    protected val _emptyLiveData = MutableLiveData<Unit>()
    val emptyLiveData: LiveData<Unit> = _emptyLiveData

    protected val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    protected val _connectLiveData = MutableLiveData<Boolean>()
    val connectLiveData: LiveData<Boolean> = _connectLiveData


    protected fun launchVM(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(context, start, block)

    protected fun globalError(error: Throwable) {
        _globalErrorLiveData.value = error.message
    }
}