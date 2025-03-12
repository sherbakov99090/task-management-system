package effective.mobile.task_management_system.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentByUserRequestDto {

    @NotNull
    private String message;

    @NotNull
    private Long taskId;

    private Long userId;

}
