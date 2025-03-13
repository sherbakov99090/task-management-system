package effective.mobile.task_management_system.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto для логина")
public class LoginDto {

    @Email
    @Schema(description = "Email зарегестрированного пользователя")
    private String email;

    @NotNull
    @Schema(description = "Password зарегестрированного пользователя")
    private String password;
}

