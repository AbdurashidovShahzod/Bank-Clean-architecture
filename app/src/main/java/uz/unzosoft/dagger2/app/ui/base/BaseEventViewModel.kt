package uz.unzosoft.dagger2.app.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.xsoft.domain.soruce.case.Event
import uz.xsoft.domain.soruce.case.EventListener

abstract class BaseEventViewModel<T>() : BaseViewModel() {
    protected val _success = MutableLiveData<List<T>>()
    val success: LiveData<List<T>> = _success

    protected val _loading = MutableLiveData<Unit>()
    val loading: LiveData<Unit> = _loading

    protected val _empty = MutableLiveData<Unit>()
    val empty: LiveData<Unit> = _empty

    protected val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    protected val eventListener = object : EventListener {
        override fun render(event: Event) {
            when (event) {
                is Event.Success<*> -> {
                    success(event.data as List<T>)
                }
                is Event.Loading -> {
                    loading()
                }
                is Event.Empty -> {
                    empty()
                }
                is Event.Error -> {
                    error(event.error)
                }
            }
        }
    }

    open fun success(list: List<T>) {
        _success.postValue(list)
    }

    open fun loading() {
        _loading.postValue(Unit)
    }

    open fun empty() {
        _empty.postValue(Unit)
    }

    open fun error(error: String) {
        _error.postValue(error)
    }

}