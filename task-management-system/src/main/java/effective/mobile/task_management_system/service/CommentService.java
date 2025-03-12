package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.CommentEntity;
import effective.mobile.task_management_system.entity.TaskEntity;
import effective.mobile.task_management_system.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TaskService taskService;
    public CommentEntity addCommentByAdmin(CommentEntity commentEntity, Long taskId) {

        commentEntity.setTask(taskService.findTaskEntityById(taskId));

        return commentRepository.save(commentEntity);
    }
    public CommentEntity addCommentByUser(CommentEntity commentEntity, Long taskId, Long userId) {

        TaskEntity taskEntity = taskService.findTaskEntityById(taskId);

        taskService.isTaskExecutor(taskEntity, userId);

        commentEntity.setTask(taskEntity);

        return commentRepository.save(commentEntity);
    }
    public void delete(Long id) {

        commentRepository.deleteById(id);
    }

}
