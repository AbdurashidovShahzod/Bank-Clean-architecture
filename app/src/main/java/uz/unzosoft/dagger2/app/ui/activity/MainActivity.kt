package uz.unzosoft.dagger2.app.ui.activity

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import uz.unzosoft.dagger2.databinding.ActivityMainBinding
import uz.unzosoft.dagger2.app.di.module.StorageMain
import uz.unzosoft.dagger2.app.model.ApiStorage
import uz.unzosoft.dagger2.app.model.LocalStorage
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var localStorage: LocalStorage

    @Inject
    lateinit var apiInject: ApiStorage

    @Inject
    lateinit var storageMain: StorageMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}