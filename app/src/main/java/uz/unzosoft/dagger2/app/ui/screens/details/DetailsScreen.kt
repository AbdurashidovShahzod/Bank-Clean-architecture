package uz.unzosoft.dagger2.app.ui.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.unzosoft.dagger2.app.ui.base.BaseScreen
import uz.unzosoft.dagger2.app.ui.utils.Config.URL_KEY
import uz.unzosoft.dagger2.databinding.DetailsScreenBinding

class DetailsScreen : BaseScreen<DetailsScreenBinding>() {
    override fun bindingScreen(i0: LayoutInflater, c0: ViewGroup?): DetailsScreenBinding {
        return DetailsScreenBinding.inflate(i0,c0,false)
    }

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        val url = arguments?.getString(URL_KEY)
        Toast.makeText(requireContext(), "$url", Toast.LENGTH_SHORT).show()
    }
}