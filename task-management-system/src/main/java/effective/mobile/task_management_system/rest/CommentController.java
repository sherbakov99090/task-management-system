package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.CommentByAdminRequestDto;
import effective.mobile.task_management_system.dto.request.CommentByUserRequestDto;
import effective.mobile.task_management_system.dto.response.CommentResponseDto;
import effective.mobile.task_management_system.dto.response.ErrorResponseDto;
import effective.mobile.task_management_system.entity.CommentEntity;
import effective.mobile.task_management_system.mapper.CommentMapper;
import effective.mobile.task_management_system.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Comment", description = "Api управления комментариями")
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper commentMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @PostMapping("/api/task/comment/create")
    @Operation(summary = "Добавление комментария админом")
    @ApiResponse(
            responseCode = "200",
            description = "Комментарий успешно добавлен.",
            content = @Content(schema = @Schema(implementation = CommentResponseDto.class))
    )
    public CommentResponseDto addComment(@Valid @RequestBody CommentByAdminRequestDto commentByAdminRequestDto) {

        CommentEntity commentEntity = commentMapper.mapToEntity(commentByAdminRequestDto);

        commentEntity = commentService.addCommentByAdmin(commentEntity, commentByAdminRequestDto.getTaskId());

        return commentMapper.mapToDto(commentEntity);
    }

    @PreAuthorize("hasAnyAuthority('USER_ROLE')")
    @PostMapping("/api/task/comment-user")
    public CommentResponseDto addComment(@Valid @RequestBody CommentByUserRequestDto commentByUserRequestDto) {

        CommentEntity commentEntity = commentMapper.mapToEntity(commentByUserRequestDto);

        commentEntity = commentService.addCommentByUser(
                commentEntity,
                commentByUserRequestDto.getTaskId(),
                commentByUserRequestDto.getUserId());

        return commentMapper.mapToDto(commentEntity);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @DeleteMapping("/api/task/comment/{id}")
    public void deleteComment(@PathVariable Long id) {

        commentService.delete(id);
    }
}
