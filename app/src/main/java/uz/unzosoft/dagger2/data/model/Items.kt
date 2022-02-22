package uz.unzosoft.dagger2.data.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.dagger2.domain.models.ItemsDto


/**
 * Created by Abdurashidov Shahzod on 22/02/22 15:47.
 * company QQBank
 * shahzod9933@gmail.com
 */

data class Items(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("node_id") var nodeId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("full_name") var fullName: Boolean? = null,
    @SerializedName("owner") var owner: Owner? = Owner(),
    @SerializedName("html_url") var htmlUrl: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("fork") var fork: Boolean? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("forks") var forks: Int? = null,
    @SerializedName("watchers") var watchers: Int? = null,

    ) {
    constructor (dto: ItemsDto) : this(
        dto.id,
        dto.nodeId,
        dto.name,
        dto.fullName,
        dto.owner,
        dto.htmlUrl,
        dto.description,
        dto.fork,
        dto.url,
        dto.language,
        dto.forks,
        dto.watchers
    )

    fun toDto(): ItemsDto {
        return ItemsDto(
            id,
            nodeId,
            name,
            fullName,
            owner,
            htmlUrl,
            description,
            fork,
            url,
            language,
            forks,
            watchers
        )
    }
}