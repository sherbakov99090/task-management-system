package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequestDto {

    private String header;

    private String description;

    private TaskStatus taskStatus;

    private TaskPriority taskPriority;

    private Long authorId;

    private Long executorId;

}
