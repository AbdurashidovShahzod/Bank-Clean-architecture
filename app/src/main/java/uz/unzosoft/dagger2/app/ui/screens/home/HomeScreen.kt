package uz.unzosoft.dagger2.app.ui.screens.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.unzosoft.dagger2.R
import uz.unzosoft.dagger2.app.ui.adapters.RepositoryAdapter
import uz.unzosoft.dagger2.app.ui.base.BaseScreen
import uz.unzosoft.dagger2.app.ui.utils.Config.URL_KEY
import uz.unzosoft.dagger2.databinding.ScreenHomeBinding
import uz.unzosoft.dagger2.domain.models.ItemsDto
import uz.unzosoft.dagger2.domain.models.RepositoryDto

class HomeScreen : BaseScreen<ScreenHomeBinding>(), RepositoryAdapter.Callback {

    private val adapter by lazy { RepositoryAdapter(this) }
    private val viewModel: HomeScreenViewModel by lazy {
        buildViewModel(this, HomeScreenViewModel::class.java)
    }


    companion object {
        const val TRIGGER_SEARCH = 1
        const val SEARCH_TRIGGER_DELAY_IN_MS: Long = 500
        var HTML_URL = ""
    }

    private val handler = Handler(Looper.getMainLooper()) {
        if (it.what == TRIGGER_SEARCH) {
            viewModel.searchRepository(binding.input.text.toString())
        }
        true
    }

    override fun bindingScreen(
        layoutInflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): ScreenHomeBinding {
        return ScreenHomeBinding.inflate(layoutInflater, viewGroup, false)
    }

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        addTextChangeListeners()
        viewModel.apply {
            repositoryLiveData.observe(viewLifecycleOwner, repositoryObserver)
            loadingLiveData.observe(viewLifecycleOwner, loadingObserver)
            errorLiveData.observe(viewLifecycleOwner, errorObserver)
            nextScreenLiveData.observe(viewLifecycleOwner, nextScreenObserver)
        }

    }

    private val repositoryObserver = Observer<RepositoryDto> {
        adapter.submitList(it.items)
        binding.rv.adapter = adapter
        binding.progressBar.visibility = View.INVISIBLE
    }
    private val loadingObserver = Observer<Unit> {
        binding.progressBar.visibility = View.VISIBLE
    }
    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
    private val nextScreenObserver = Observer<Unit> {

    }

    private fun addTextChangeListeners() {
        binding.input.doAfterTextChanged {
            if (it.toString().isNotEmpty()) {
                it?.let {
                    handler.removeMessages(TRIGGER_SEARCH)
                    handler.sendEmptyMessageDelayed(TRIGGER_SEARCH, SEARCH_TRIGGER_DELAY_IN_MS)
                }
            } else {
                adapter.submitList(emptyList())
                binding.emptyTv.text = getString(R.string.search_query_hint)
                binding.rv.adapter = adapter
            }
        }
    }

    override fun repository(dto: ItemsDto) {
        HTML_URL = dto.htmlUrl.toString()
        val action = HomeScreenDirections.actionHomeScreenToDetailsScreen(HTML_URL)
        findNavController().navigate(action)
    }
}