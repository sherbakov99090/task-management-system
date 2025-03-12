package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.CommentByAdminRequestDto;
import effective.mobile.task_management_system.dto.request.CommentByUserRequestDto;
import effective.mobile.task_management_system.dto.response.CommentResponseDto;
import effective.mobile.task_management_system.entity.CommentEntity;
import effective.mobile.task_management_system.mapper.CommentMapper;
import effective.mobile.task_management_system.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper commentMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @PostMapping("/api/task/comment-admin")
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
