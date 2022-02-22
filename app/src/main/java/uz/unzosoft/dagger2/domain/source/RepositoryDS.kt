package uz.unzosoft.dagger2.domain.source

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.dagger2.domain.models.RepositoryDto
import uz.unzosoft.dagger2.domain.util.ResourceUI

interface RepositoryDS {
    suspend fun repository(search: String): Flow<ResourceUI<RepositoryDto>>
}