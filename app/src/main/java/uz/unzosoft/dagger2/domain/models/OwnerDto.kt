package uz.unzosoft.dagger2.domain.models


/**
 * Created by Abdurashidov Shahzod on 22/02/22 15:51.
 * company QQBank
 * shahzod9933@gmail.com
 */

data class OwnerDto(
    var login: String? = null,
    var id: Int? = null,
    var nodeId: String? = null,
    var avatarUrl: String? = null,
    var gravatarId: String? = null,
    var url: String? = null,
    var htmlUrl: String? = null,
    var reposUrl: String? = null
)