package effective.mobile.task_management_system.dto.request;

import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import effective.mobile.task_management_system.validation.ValidEnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto для создания задачи администратором")
public class TaskCreateRequestDto {

    @NotNull
    @Schema(description = "Заголовок задачи")
    private String header;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Статус задачи")
    @ValidEnumValue(TaskStatus.class)
    private TaskStatus taskStatus;

    @Schema(description = "Приоритет задачи")
    @ValidEnumValue(TaskPriority.class)
    private TaskPriority taskPriority;

    @Schema(description = " Id автора задачи")
    @NotNull
    private Long authorId;

    @Schema(description = " Id исполнителя задачи")
    @NotNull
    private Long executorId;

}
