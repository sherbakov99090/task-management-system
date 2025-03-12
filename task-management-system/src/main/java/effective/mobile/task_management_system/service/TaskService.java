package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.*;
import effective.mobile.task_management_system.exception.ExceptionMessage;
import effective.mobile.task_management_system.exception.TaskEntityNotFoundException;
import effective.mobile.task_management_system.exception.UserEntityNotExecutorTaskException;
import effective.mobile.task_management_system.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    private final ExceptionMessage exceptionMessage;

    @Transactional
    public TaskEntity addTask(TaskEntity taskEntity, Long authorId, Long executorId) {

        UserEntity taskAuthor = userService.findByUserById(authorId);

        UserEntity taskExecutor = userService.findByUserById(executorId);

        taskEntity.setUserEntityAuthor(taskAuthor);

        taskEntity.setUserEntityExecutor(taskExecutor);

        taskEntity = taskRepository.save(taskEntity);

        return taskEntity;
    }


    @Transactional
    public TaskEntity updateTaskByAdmin(Long id, String header, String description, TaskStatus taskStatus, TaskPriority taskPriority, Long executorId) {

        TaskEntity taskEntity = findTaskEntityById(id);

        if (header != null) {
            taskEntity.setHeader(header);
        }

        if (description != null) {
            taskEntity.setDescription(description);
        }

        if (taskStatus != null) {
            taskEntity.setTaskStatus(taskStatus);
        }

        if (taskPriority != null) {
            taskEntity.setTaskPriority(taskPriority);
        }

        if (executorId != null) {
            UserEntity userEntity = userService.findByUserById(executorId);
            taskEntity.setUserEntityExecutor(userEntity);
        }

        return taskRepository.save(taskEntity);
    }

    @Transactional
    public TaskEntity updateTaskByUser(Long taskId, Long userId, TaskStatus taskStatus) {

        TaskEntity taskEntity = findTaskEntityById(taskId);

        isTaskExecutor(taskEntity, userId);

        taskEntity.setTaskStatus(taskStatus);

        return taskRepository.save(taskEntity);

    }

    public boolean isTaskExecutor(TaskEntity taskEntity, Long userId) {

        if (Objects.equals(taskEntity.getUserEntityExecutor().getId(), userId)) {
            return true;
        } else {
            throw new UserEntityNotExecutorTaskException(exceptionMessage.getUserNotExecutorTask());
        }
    }

    public void deleteTask(Long id) {

        taskRepository.deleteById(id);

    }

    public List<TaskEntity> findAllTask() {

        return taskRepository.findAll();
    }

    public TaskEntity findTaskEntityById(Long id) {

        return taskRepository.findById(id).
                orElseThrow(() -> new TaskEntityNotFoundException(exceptionMessage.getTaskEntityNotFound() + id));
    }


    public void deleteAllTask() {

        taskRepository.deleteAll();
    }

    public List<TaskEntity> getAllTaskByAuthor(Long id) {

        UserEntity userEntity = userService.findByUserById(id);

        return new ArrayList<>(userEntity.getAuthoredTaskEntities());
    }

    public List<TaskEntity> getAllTaskByExecutor(Long id) {

        UserEntity userEntity = userService.findByUserById(id);

        return new ArrayList<>(userEntity.getExecutorTaskEntities());
    }
}

