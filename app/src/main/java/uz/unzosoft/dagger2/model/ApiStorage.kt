package uz.unzosoft.dagger2.model

import dagger.Module
import javax.inject.Inject

@Module
class ApiStorage
@Inject
constructor() {
    val apiStorage: String = "Api storage"
}