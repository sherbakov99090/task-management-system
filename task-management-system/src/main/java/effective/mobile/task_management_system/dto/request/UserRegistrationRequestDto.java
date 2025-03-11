package effective.mobile.task_management_system.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
