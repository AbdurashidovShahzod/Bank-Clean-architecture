package uz.unzosoft.dagger2.app.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import uz.unzosoft.dagger2.databinding.ScreenHomeBinding
import uz.unzosoft.dagger2.app.ui.base.BaseScreen
import uz.unzosoft.dagger2.domain.models.RepositoryDto

class HomeScreen : BaseScreen<ScreenHomeBinding>() {

    private val viewModel: HomeScreenViewModel by lazy {
        buildViewModel(this, HomeScreenViewModel::class.java)
    }

    override fun bindingScreen(
        layoutInflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): ScreenHomeBinding {
        return ScreenHomeBinding.inflate(layoutInflater, viewGroup, false)
    }

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        viewModel.apply {
            homeLiveData.observe(viewLifecycleOwner, homeObserver)
            repositoryLiveData.observe(viewLifecycleOwner, repositoryObserver)
        }
    }

    private val homeObserver = Observer<String> {
        binding.tv.text = it
    }
    private val repositoryObserver = Observer<RepositoryDto> {
        binding.tv.text = it.toString()
    }
}