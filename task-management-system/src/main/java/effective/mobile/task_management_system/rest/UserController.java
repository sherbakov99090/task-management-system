package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.UserRegistrationRequestDto;
import effective.mobile.task_management_system.dto.response.UserRegistrationResponseDto;
import effective.mobile.task_management_system.entity.User;
import effective.mobile.task_management_system.mapper.UserMapper;
import effective.mobile.task_management_system.service.UserService;
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
    public ResponseEntity<UserRegistrationResponseDto> userRegistration(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {

        User user = userMapper.mapToEntity(userRegistrationRequestDto);

        userService.userExistsByEmail(user.getUsername());

        user = userService.saveUser(user);

        UserRegistrationResponseDto responseDto = userMapper.mapToDto(user);

        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

//    @PutMapping("/api/users/update_role_user")
//    public ResponseEntity<UserUpdateRoleResponceDto> updateUserRoles()

}
