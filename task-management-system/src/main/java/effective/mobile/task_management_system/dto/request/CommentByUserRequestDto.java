package effective.mobile.task_management_system.dto.request;

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
@Schema(description = "Dto для добавления комментария пользователем")
public class CommentByUserRequestDto {

    @NotNull
    @Schema(description = "Сообщение комментария")
    private String message;

    @NotNull
    @Schema(description = "Id задачи к которой относится комментарий")
    private Long taskId;

    @Schema(description = "Id пользователя являющегося исполнителем задачи")
    private Long userId;

}
