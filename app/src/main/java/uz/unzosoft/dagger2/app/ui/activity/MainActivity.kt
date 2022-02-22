package uz.unzosoft.dagger2.app.ui.activity

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import uz.unzosoft.dagger2.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}