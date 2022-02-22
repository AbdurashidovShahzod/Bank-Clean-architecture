package uz.unzosoft.dagger2.app.di.module

import dagger.Binds
import dagger.Module
import uz.unzosoft.dagger2.data.usecase.RepositoryUseCaseImp
import uz.unzosoft.dagger2.domain.usecase.RepositoryUseCase

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindRepositoryUseCase(repositoryUseCaseImp: RepositoryUseCaseImp): RepositoryUseCase
}