package uz.unzosoft.dagger2.app.di.control

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppCacheQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EncryptedCacheQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ServiceQualifier
