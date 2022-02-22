package uz.unzosoft.dagger2.app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment
import uz.unzosoft.dagger2.app.ui.utils.ViewModelProvideFactory
import javax.inject.Inject


abstract class BaseScreen<T : ViewBinding>() : DaggerFragment() {

    protected val TAG: String = "TAG"

    @Inject
    protected lateinit var providerFactory: ViewModelProvideFactory


    protected var _binding: T? = null
    protected lateinit var binding: T

    companion object {
        val DATA_ID = "_ID"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingScreen(inflater, container)
        binding = _binding as T
        return binding.root
    }

    abstract fun bindingScreen(
        i0: LayoutInflater,
        c0: ViewGroup?
    ): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate(view, savedInstanceState)
    }

    abstract fun onViewCreate(view: View, savedInstanceState: Bundle?)

    fun <T : ViewModel> buildViewModel(
        @NonNull owner: ViewModelStoreOwner = this,
        viewModel: Class<T>
    ): T {
        return ViewModelProvider(owner, providerFactory)[viewModel]
    }

    inline fun <T : ViewBinding> Fragment.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T
    ) = lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}