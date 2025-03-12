package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.CommentRequestDto;
import effective.mobile.task_management_system.dto.response.CommentResponseDto;
import effective.mobile.task_management_system.entity.CommentEntity;
import effective.mobile.task_management_system.mapper.CommentMapper;
import effective.mobile.task_management_system.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper commentMapper;


    @PostMapping("/api/task/comment")
    public CommentResponseDto addComment(@Valid @RequestBody CommentRequestDto commentRequestDto) {

        CommentEntity commentEntity = commentService.addComments(commentRequestDto.getMessage(), commentRequestDto.getTaskId());

        return commentMapper.mapToDto(commentEntity);
    }

    @DeleteMapping("/api/task/comment/{id}")
    public void deleteComment(@PathVariable Long id) {

        commentService.delete(id);
    }
}
