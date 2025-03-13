package effective.mobile.task_management_system.dto.response;

import effective.mobile.task_management_system.entity.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO ответа пользователя")
public class UserResponseDto {

    @Schema(description = "Id пользователя")
    private Long id;

    @Schema(description = "Имя пользователя")
    private String firstName;

    @Schema(description = "Фамилия пользователя")
    private String lastName;

    @Schema(description = "email пользователя")
    private String email;

    @Schema(description = "Роль пользователя")
    private UserRole userRole;

}