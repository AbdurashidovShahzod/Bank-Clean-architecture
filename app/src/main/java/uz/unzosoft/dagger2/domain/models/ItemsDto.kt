package uz.unzosoft.dagger2.domain.models

import uz.unzosoft.dagger2.data.model.Owner


/**
 * Created by Abdurashidov Shahzod on 22/02/22 15:47.
 * company QQBank
 * shahzod9933@gmail.com
 */

data class ItemsDto(
    var id: Int? = null,
    var nodeId: String? = null,
    var name: String? = null,
    var fullName: Boolean? = null,
    var owner: Owner? = Owner(),
    var htmlUrl: String? = null,
    var description: String? = null,
    var fork: Boolean? = null,
    var url: String? = null,
    var language: String? = null
)