package uz.unzosoft.dagger2.app.model

import dagger.Module
import javax.inject.Inject

@Module
class LocalStorage @Inject constructor() {
    val storage: String = "My shared preference"
}