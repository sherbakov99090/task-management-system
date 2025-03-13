package effective.mobile.task_management_system.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto для регистрации нового пользователя")
public class UserRegistrationRequestDto {

    @NotNull
    @Schema(description = "Имя пользователя")
    private String firstName;

    @NotNull
    @Schema(description = "Фамилия пользователя")
    private String lastName;

    @Email
    @Schema(description = "Email пользователя")
    private String email;

    @NotNull
    @Schema(description = "Password пользователя")
    private String password;

}
