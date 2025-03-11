package effective.mobile.task_management_system.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {

    private Long id;

    private String header;

    private String description;

    private TaskStatus taskStatus;

    private TaskPriority taskPriority;

    private Long authorId;

    private Long executorId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentResponseDto> commentResponseDtoList;

}
