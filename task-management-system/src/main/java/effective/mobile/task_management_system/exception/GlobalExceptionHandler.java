package effective.mobile.task_management_system.exception;

import effective.mobile.task_management_system.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(TaskEntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleTaskEntityNotFoundException(TaskEntityNotFoundException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(UserEntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserEntityNotFoundException(UserEntityNotFoundException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDtoResponse);
    }

    @ResponseBody
    @ExceptionHandler(UserEntityExistsEmailException.class)
    public ResponseEntity<ErrorResponseDto> handleUserEntityExistsEmailException(UserEntityExistsEmailException e) {

        ErrorResponseDto errorDtoResponse = new ErrorResponseDto();
        errorDtoResponse.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDtoResponse);
    }
}
