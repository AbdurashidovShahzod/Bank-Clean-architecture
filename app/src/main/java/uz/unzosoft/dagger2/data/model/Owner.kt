package uz.unzosoft.dagger2.data.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.dagger2.domain.models.OwnerDto


/**
 * Created by Abdurashidov Shahzod on 22/02/22 15:51.
 * company QQBank
 * shahzod9933@gmail.com
 */

data class Owner(

    @SerializedName("login") var login: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("node_id") var nodeId: String? = null,
    @SerializedName("avatar_url") var avatarUrl: String? = null,
    @SerializedName("gravatar_id") var gravatarId: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("html_url") var htmlUrl: String? = null,
    @SerializedName("repos_url") var reposUrl: String? = null,
) {
    constructor (dto: OwnerDto) : this(
        dto.login,
        dto.id,
        dto.nodeId,
        dto.avatarUrl,
        dto.gravatarId,
        dto.url,
        dto.htmlUrl,
        dto.reposUrl
    )

    fun toDto(): OwnerDto {
        return OwnerDto(
            login,
            id,
            nodeId,
            avatarUrl,
            gravatarId,
            url,
            htmlUrl,
            reposUrl
        )
    }
}

