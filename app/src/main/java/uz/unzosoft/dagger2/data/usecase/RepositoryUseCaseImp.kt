package uz.unzosoft.dagger2.data.usecase

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.repository.GitHubRepository
import uz.unzosoft.dagger2.domain.usecase.RepositoryUseCase
import uz.unzosoft.dagger2.domain.util.ResourceUI
import javax.inject.Inject

class RepositoryUseCaseImp @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : RepositoryUseCase {
    override suspend fun invoke(search: String): Flow<ResourceUI<RepositoryDto>> {
        return gitHubRepository.repository(search)
    }
}