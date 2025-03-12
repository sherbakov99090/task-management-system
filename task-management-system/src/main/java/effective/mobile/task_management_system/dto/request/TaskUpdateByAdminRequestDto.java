package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import effective.mobile.task_management_system.validation.ValidEnumValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateByAdminRequestDto {

    @NotNull
    private Long id;

    private String header;

    private String description;

    @ValidEnumValue(TaskStatus.class)
    private TaskStatus taskStatus;

    @ValidEnumValue(TaskPriority.class)
    private TaskPriority taskPriority;

    private Long executorId;
}
