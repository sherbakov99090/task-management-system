package effective.mobile.task_management_system.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

    @NotNull
    private String message;

    @NotNull
    private Long taskId;
}
