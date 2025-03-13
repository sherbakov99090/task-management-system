package effective.mobile.task_management_system.exception;

import effective.mobile.task_management_system.dto.response.ErrorResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.exception.message.taskEntity.notFound}")
    private String taskEntityNotFound;

    @Value("${spring.exception.message.userEntity.notFound}")
    private String userEntityNotFound;

    @Value("${spring.exception.message.userEntity.existsEmail}")
    private String userExistsByEmail;

    @Value("${spring.exception.message.userEntity.notExecutorTask}")
    private String userNotExecutorTask;


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(TaskEntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleTaskEntityNotFoundException(TaskEntityNotFoundException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(taskEntityNotFound);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(UserEntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserEntityNotFoundException(UserEntityNotFoundException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(userEntityNotFound);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(UserEntityExistsEmailException.class)
    public ResponseEntity<ErrorResponseDto> handleUserEntityExistsEmailException(UserEntityExistsEmailException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(userExistsByEmail);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(UserEntityNotExecutorTaskException.class)
    public ResponseEntity<ErrorResponseDto> handleUserEntityNotExecutorTaskException(UserEntityNotExecutorTaskException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(userNotExecutorTask);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDtoResponse);
    }
}
