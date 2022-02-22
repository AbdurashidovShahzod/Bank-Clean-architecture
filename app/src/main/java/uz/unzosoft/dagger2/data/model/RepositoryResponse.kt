package uz.unzosoft.dagger2.data.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.dagger2.domain.models.RepositoryDto


/**
 * Created by Abdurashidov Shahzod on 22/02/22 15:43.
 * company QQBank
 * shahzod9933@gmail.com
 */
data class RepositoryResponse(
    @SerializedName("items") var items: List<Items> = arrayListOf()
) {
    constructor(dto: RepositoryDto) : this(
        dto.items.map { Items(it) }
    )

    fun toDto(): RepositoryDto {
        return RepositoryDto(
            items.map { it.toDto() }
        )
    }
}
