package effective.mobile.task_management_system.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto для добавления комментария администратором")
public class CommentByAdminRequestDto {

    @NotNull
    @Schema(description = "Сообщение комментария")
    private String message;

    @NotNull
    @Schema(description = "Id задачи к которой относится комментарий")
    private Long taskId;
}
