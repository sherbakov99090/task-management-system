package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.UserRegistrationRequestDto;
import effective.mobile.task_management_system.dto.response.UserResponseDto;
import effective.mobile.task_management_system.entity.UserEntity;
import effective.mobile.task_management_system.entity.UserRole;
import effective.mobile.task_management_system.mapper.UserMapper;
import effective.mobile.task_management_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/api/users/registration")
    public ResponseEntity<UserResponseDto> userRegistration(@Valid @RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {

        UserEntity userEntity = userMapper.mapToEntity(userRegistrationRequestDto, UserRole.USER_ROLE);

        userEntity = userService.saveUser(userEntity);

        UserResponseDto responseDto = userMapper.mapToDto(userEntity);

        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

}
