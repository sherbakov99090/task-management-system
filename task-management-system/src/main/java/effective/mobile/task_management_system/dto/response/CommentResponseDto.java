package effective.mobile.task_management_system.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto ответа о создании комментария")
public class CommentResponseDto {

    @Schema(description = "Id комментария")
    private Long id;

    @Schema(description = "Текст комментария")
    private String message;

    @Schema(description = "Дата и время создания комментария", example = "2023-10-15T14:30:00Z")
    private LocalDateTime createdAt;

    @Schema(description = "Дата и время последнего обновления комментария", example = "2023-10-16T09:45:00Z")
    private LocalDateTime updatedAt;

    @Schema(description = "Идентификатор задачи, к которой относится комментарий")
    private Long taskId;
}
