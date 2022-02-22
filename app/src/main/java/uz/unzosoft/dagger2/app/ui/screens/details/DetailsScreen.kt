package uz.unzosoft.dagger2.app.ui.screens.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import uz.unzosoft.dagger2.app.ui.base.BaseScreen
import uz.unzosoft.dagger2.databinding.DetailsScreenBinding

class DetailsScreen : BaseScreen<DetailsScreenBinding>() {
    private val args :DetailsScreenArgs by navArgs()
    override fun bindingScreen(i0: LayoutInflater, c0: ViewGroup?): DetailsScreenBinding {
        return DetailsScreenBinding.inflate(i0,c0,false)
    }

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        show(args.url,"Github")
    }
    @SuppressLint("SetJavaScriptEnabled")
    fun show(link : String, title:String) {
        val wb = binding.webView
        wb.settings.domStorageEnabled = true
        wb.settings.javaScriptEnabled = true
        wb.isVerticalScrollBarEnabled = true
        wb.settings.pluginState = WebSettings.PluginState.ON
        wb.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

            }
        }
        if (args.url.isNotEmpty()){
            wb.loadUrl(args.url)
        }

    }
}