package uz.unzosoft.dagger2.app.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import uz.unzosoft.dagger2.databinding.ScreenHomeBinding
import uz.unzosoft.dagger2.app.ui.base.BaseScreen

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
        }
    }

    private val homeObserver = Observer<String> {
        binding.tv.text = it
    }
}