package effective.mobile.task_management_system.mapper;

import effective.mobile.task_management_system.dto.response.CommentResponseDto;
import effective.mobile.task_management_system.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "taskId" , source = "task.id")
    CommentResponseDto mapToDto(CommentEntity commentEntity);

    List<CommentResponseDto> mapToDto(List<CommentEntity> commentEntity);
}
