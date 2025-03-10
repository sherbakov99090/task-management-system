package effective.mobile.task_management_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRegistrationResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    @Value("${spring.response.registration.message}")
    private String message;
}