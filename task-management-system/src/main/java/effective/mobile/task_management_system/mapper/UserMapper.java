package effective.mobile.task_management_system.mapper;

import effective.mobile.task_management_system.dto.request.UserRegistrationRequestDto;
import effective.mobile.task_management_system.dto.response.UserResponseDto;
import effective.mobile.task_management_system.entity.UserEntity;
import effective.mobile.task_management_system.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userRole", source = "userRole")
    UserEntity mapToEntity(UserRegistrationRequestDto requestDto, UserRole userRole);
    UserResponseDto mapToDto(UserEntity userEntity);

}
