package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import effective.mobile.task_management_system.validation.ValidEnumValue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequestDto {

    @NotNull
    private String header;

    private String description;

    @ValidEnumValue(TaskStatus.class)
    private TaskStatus taskStatus;

    @ValidEnumValue(TaskPriority.class)
    private TaskPriority taskPriority;

    @NotNull
    private Long authorId;

    @NotNull
    private Long executorId;

}
