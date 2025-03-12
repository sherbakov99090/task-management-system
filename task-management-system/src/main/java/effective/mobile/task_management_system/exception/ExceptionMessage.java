package effective.mobile.task_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ExceptionMessage {

    @Value("${spring.exception.message.taskEntity.notFound}")
    private String taskEntityNotFound;

    @Value("${spring.exception.message.userEntity.notFound}")
    private String userEntityNotFound;

    @Value("${spring.exception.message.userEntity.existsEmail}")
    private String userExistsByEmail;

    @Value("${spring.exception.message.userEntity.notExecutorTask}")
    private String userNotExecutorTask;
}
