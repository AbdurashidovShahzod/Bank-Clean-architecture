package uz.unzosoft.dagger2.app.di.module

import dagger.Binds
import dagger.Module
import uz.unzosoft.dagger2.data.repository.GitHubRepositoryImp
import uz.unzosoft.dagger2.data.source.RepositoryDSImp
import uz.unzosoft.dagger2.domain.repository.GitHubRepository
import uz.unzosoft.dagger2.domain.source.RepositoryDS

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindRepositoryDataSource(repositoryDSImp: RepositoryDSImp): RepositoryDS
}