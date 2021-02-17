package uz.unzosoft.dagger2.model

import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class LocalStorage @Inject constructor() {
    val storage: String = "My shared preference"
}