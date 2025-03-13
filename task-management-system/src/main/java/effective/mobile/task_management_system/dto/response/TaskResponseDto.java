package effective.mobile.task_management_system.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import effective.mobile.task_management_system.entity.TaskPriority;
import effective.mobile.task_management_system.entity.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto ответа о создании задачи")
public class TaskResponseDto {

    @Schema(description = "Id задачи")
    private Long id;

    @Schema(description = "Заголовок задачи")
    private String header;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Статус задачи")
    private TaskStatus taskStatus;

    @Schema(description = "Приоритет задачи")
    private TaskPriority taskPriority;

    @Schema(description = "Id автора задачи")
    private Long authorId;

    @Schema(description = "Id исполнителя задачи")
    private Long executorId;

    @Schema(description = "Список комментариев к задаче")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentResponseDto> commentResponseDtoList;

}
