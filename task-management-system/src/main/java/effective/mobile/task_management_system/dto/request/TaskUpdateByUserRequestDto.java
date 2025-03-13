package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskStatus;
import effective.mobile.task_management_system.validation.ValidEnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto для изменения задачи пользователем")
public class TaskUpdateByUserRequestDto {

    @NotNull
    @Schema(description = "Id изменяемой задачи")
    private Long id;

    @NotNull
    @ValidEnumValue(TaskStatus.class)
    @Schema(description = "Новый статус задачи")
    private TaskStatus taskStatus;

    @NotNull
    @Schema(description = "Id пользователя являющегося исполнителем задачи")
    private Long userId;
}
