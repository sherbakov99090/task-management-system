package effective.mobile.task_management_system.dto.response;

import effective.mobile.task_management_system.entity.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private UserRole userRole;

}