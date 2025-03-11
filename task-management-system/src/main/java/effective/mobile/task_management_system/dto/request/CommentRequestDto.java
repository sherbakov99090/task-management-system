package effective.mobile.task_management_system.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

    private String message;

    private Long taskId;
}
