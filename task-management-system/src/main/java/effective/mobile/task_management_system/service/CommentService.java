package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.CommentEntity;
import effective.mobile.task_management_system.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final TaskService taskService;

    public CommentEntity addComments(String message, Long taskId) {

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setMessage(message);
        commentEntity.setTask(taskService.getTaskById(taskId));

        return commentRepository.save(commentEntity);
    }

    public void delete(Long id) {

        commentRepository.deleteById(id);
    }

}
