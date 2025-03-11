package effective.mobile.task_management_system.mapper;

import effective.mobile.task_management_system.dto.request.TaskCreateRequestDto;
import effective.mobile.task_management_system.dto.response.TaskResponseDto;
import effective.mobile.task_management_system.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface TaskMapper {

    TaskEntity mapToEntity(TaskCreateRequestDto requestDto);

    @Mapping(target = "authorId", source = "userEntityAuthor.id")
    @Mapping(target = "executorId", source = "userEntityExecutor.id")
    @Mapping(target = "commentResponseDtoList", source = "commentEntities")
    TaskResponseDto mapToDto(TaskEntity taskEntity);

    List<TaskResponseDto> mapToEntity(List<TaskEntity> taskEntities);

}
