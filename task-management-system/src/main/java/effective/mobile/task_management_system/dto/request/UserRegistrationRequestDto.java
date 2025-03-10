package effective.mobile.task_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRegistrationRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
