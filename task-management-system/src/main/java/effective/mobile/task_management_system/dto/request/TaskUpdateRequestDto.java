package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequestDto {

    private Long id;

    private String header;

    private String description;

    private TaskStatus taskStatus;

    private TaskPriority taskPriority;

    private Long executorId;
}
