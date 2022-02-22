package uz.unzosoft.dagger2.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.util.ResourceUI

interface GitHubRepository {
    suspend fun repository(search: String): Flow<ResourceUI<RepositoryDto>>
}