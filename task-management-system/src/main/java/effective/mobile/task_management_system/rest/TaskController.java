package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.TaskCreateRequestDto;
import effective.mobile.task_management_system.dto.request.TaskUpdateRequestDto;
import effective.mobile.task_management_system.dto.response.TaskResponseDto;
import effective.mobile.task_management_system.entity.TaskEntity;
import effective.mobile.task_management_system.mapper.TaskMapper;
import effective.mobile.task_management_system.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @PostMapping("/api/task")
    public TaskResponseDto addTask(@Valid @RequestBody TaskCreateRequestDto taskCreateRequestDto) {

        TaskEntity taskEntity = taskMapper.mapToEntity(taskCreateRequestDto);

        taskEntity = taskService.addTask(taskEntity, taskCreateRequestDto.getAuthorId(), taskCreateRequestDto.getExecutorId());

        return taskMapper.mapToDto(taskEntity);
    }

    @PatchMapping("/api/task/update")
    public TaskResponseDto updateTask(@Valid @RequestBody TaskUpdateRequestDto taskUpdateRequestDto) {


        TaskEntity taskEntity = taskService.updateTask(
                taskUpdateRequestDto.getId(),
                taskUpdateRequestDto.getHeader(),
                taskUpdateRequestDto.getDescription(),
                taskUpdateRequestDto.getTaskStatus(),
                taskUpdateRequestDto.getTaskPriority(),
                taskUpdateRequestDto.getExecutorId());

        TaskResponseDto responseDto = taskMapper.mapToDto(taskEntity);

        return responseDto;
    }

    @DeleteMapping("/api/task/delete/{id}")
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
    }

    @DeleteMapping("/api/task/deleteAll")
    public void deleteTask() {

        taskService.deleteAllTask();
    }

    @GetMapping("/api/task/getAll")
    public List<TaskResponseDto> findAllTask() {

        List<TaskEntity> taskEntities = taskService.findAllTask();

        return taskMapper.mapToEntity(taskEntities);
    }

    @GetMapping("/api/task/taskAuthor/{id}")
    public List<TaskResponseDto> getAllTaskByAuthor(@PathVariable Long id ){
       return taskMapper.mapToEntity(taskService.getAllTaskByAuthor(id));

    }


    @GetMapping("/api/task/taskExecutor/{id}")
    public List<TaskResponseDto> getAllTaskByExecutor(@PathVariable Long id ){
        return taskMapper.mapToEntity(taskService.getAllTaskByExecutor(id));

    }


}
