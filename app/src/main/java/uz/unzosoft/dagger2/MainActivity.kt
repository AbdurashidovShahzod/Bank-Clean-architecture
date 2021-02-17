package uz.unzosoft.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import uz.unzosoft.dagger2.databinding.ActivityMainBinding
import uz.unzosoft.dagger2.model.AuthApi
import uz.unzosoft.dagger2.model.LocalStorage
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var localStorage: LocalStorage

    @Inject
    lateinit var api: AuthApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tv.text = localStorage.storage
        }
    }
}