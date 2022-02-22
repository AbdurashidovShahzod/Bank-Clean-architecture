package uz.unzosoft.dagger2.app.di.module

import dagger.Binds
import dagger.Module
import uz.unzosoft.dagger2.data.repository.GitHubRepositoryImp
import uz.unzosoft.dagger2.domain.repository.GitHubRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindGithubRepository(gitHubRepositoryImp: GitHubRepositoryImp): GitHubRepository
}