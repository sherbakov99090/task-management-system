package effective.mobile.task_management_system.mapper;

import effective.mobile.task_management_system.dto.request.UserRegistrationRequestDto;
import effective.mobile.task_management_system.dto.response.UserRegistrationResponseDto;
import effective.mobile.task_management_system.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User mapToEntity(UserRegistrationRequestDto requestDto);
    UserRegistrationResponseDto mapToDto(User user);

}
