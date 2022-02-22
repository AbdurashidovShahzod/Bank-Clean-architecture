package uz.unzosoft.dagger2.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.util.ResourceUI

interface RepositoryUseCase {
    suspend fun invoke(search: String): Flow<ResourceUI<RepositoryDto>>
}