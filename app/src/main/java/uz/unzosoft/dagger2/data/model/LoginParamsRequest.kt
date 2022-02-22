package uz.unzosoft.dagger2.data.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.dagger2.domain.models.LoginParamsDto

data class LoginParamsRequest(
    @SerializedName("email") var email: String? = null,
    @SerializedName("password") var password: String? = null,
) {

    constructor(dto: LoginParamsDto) : this(
        dto.email,
        dto.password
    )

    fun toDto(): LoginParamsDto {
        return LoginParamsDto(
            email,
            password
        )
    }
}
