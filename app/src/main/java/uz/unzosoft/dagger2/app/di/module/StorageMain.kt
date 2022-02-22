package uz.unzosoft.dagger2.app.di.module

import dagger.Module
import javax.inject.Inject

@Module
class StorageMain @Inject constructor(){
    val roomStorageMain: String = "Main stoarage room"
}