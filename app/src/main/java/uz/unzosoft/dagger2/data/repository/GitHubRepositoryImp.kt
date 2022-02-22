package uz.unzosoft.dagger2.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.repository.GitHubRepository
import uz.unzosoft.dagger2.domain.source.RepositoryDS
import uz.unzosoft.dagger2.domain.util.ResourceUI
import javax.inject.Inject

class GitHubRepositoryImp @Inject constructor(
    private val repositoryDS: RepositoryDS
) : GitHubRepository {
    override suspend fun repository(search: String): Flow<ResourceUI<RepositoryDto>> =
        withContext(Dispatchers.IO) {
            repositoryDS.repository(search)
        }
}