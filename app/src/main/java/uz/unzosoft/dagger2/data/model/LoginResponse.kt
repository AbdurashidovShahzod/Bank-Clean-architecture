package uz.unzosoft.dagger2.data.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.dagger2.domain.models.LoginDto

data class LoginResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("token") var token: String? = null,
    @SerializedName("expires_at") var expiresAt: String? = null
) {

    constructor(dto: LoginDto) : this(
        dto.id,
        dto.name,
        dto.token,
        dto.expiresAt
    )

    fun toDto(): LoginDto {
        return LoginDto(
            id,
            name,
            token,
            expiresAt
        )
    }
}
