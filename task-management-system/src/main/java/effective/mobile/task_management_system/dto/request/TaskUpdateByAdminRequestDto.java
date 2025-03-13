package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
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
@Schema(description = "Dto для изменения задачи администратором")
public class TaskUpdateByAdminRequestDto {

    @NotNull
    @Schema(description = "Id изменяемой задачи")
    private Long id;

    @NotNull
    @Schema(description = "Новый заголовок задачи")
    private String header;

    @Schema(description = "новое описание задачи")
    private String description;

    @Schema(description = "Новый статус задачи")
    @ValidEnumValue(TaskStatus.class)
    private TaskStatus taskStatus;

    @Schema(description = "Новый приоритет задачи")
    @ValidEnumValue(TaskPriority.class)
    private TaskPriority taskPriority;

    @Schema(description = " Новый Id исполнителя задачи")
    @NotNull
    private Long executorId;


}
