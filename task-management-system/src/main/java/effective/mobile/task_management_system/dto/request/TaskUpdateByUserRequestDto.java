package effective.mobile.task_management_system.dto.request;

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
public class TaskUpdateByUserRequestDto {

    @NotNull
    private Long id;

    @ValidEnumValue(TaskStatus.class)
    private TaskStatus taskStatus;

    @NotNull
    private Long userId;
}
