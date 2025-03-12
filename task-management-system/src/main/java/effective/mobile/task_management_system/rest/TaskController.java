package effective.mobile.task_management_system.rest;

import effective.mobile.task_management_system.dto.request.TaskCreateRequestDto;
import effective.mobile.task_management_system.dto.request.TaskUpdateByAdminRequestDto;
import effective.mobile.task_management_system.dto.request.TaskUpdateByUserRequestDto;
import effective.mobile.task_management_system.dto.response.TaskResponseDto;
import effective.mobile.task_management_system.entity.TaskEntity;
import effective.mobile.task_management_system.mapper.TaskMapper;
import effective.mobile.task_management_system.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @PostMapping("/api/task")
    public TaskResponseDto addTask(@Valid @RequestBody TaskCreateRequestDto taskCreateRequestDto) {

        TaskEntity taskEntity = taskMapper.mapToEntity(taskCreateRequestDto);

        taskEntity = taskService.addTask(taskEntity, taskCreateRequestDto.getAuthorId(), taskCreateRequestDto.getExecutorId());

        return taskMapper.mapToDto(taskEntity);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @PatchMapping("/api/task/update-admin")
    public TaskResponseDto updateTask(@Valid @RequestBody TaskUpdateByAdminRequestDto taskUpdateByAdminRequestDto) {


        TaskEntity taskEntity = taskService.updateTaskByAdmin(
                taskUpdateByAdminRequestDto.getId(),
                taskUpdateByAdminRequestDto.getHeader(),
                taskUpdateByAdminRequestDto.getDescription(),
                taskUpdateByAdminRequestDto.getTaskStatus(),
                taskUpdateByAdminRequestDto.getTaskPriority(),
                taskUpdateByAdminRequestDto.getExecutorId());

        return taskMapper.mapToDto(taskEntity);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @DeleteMapping("/api/task/delete/{id}")
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @DeleteMapping("/api/task/delete/all")
    public void deleteTask() {

        taskService.deleteAllTask();
    }
    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @GetMapping("/api/task/get/all")
    public List<TaskResponseDto> findAllTask() {

        List<TaskEntity> taskEntities = taskService.findAllTask();

        return taskMapper.mapToEntity(taskEntities);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @GetMapping("/api/task/author/{id}")
    public List<TaskResponseDto> getAllTaskByAuthor(@PathVariable Long id ){
       return taskMapper.mapToEntity(taskService.getAllTaskByAuthor(id));

    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @GetMapping("/api/task/executor/{id}")
    public List<TaskResponseDto> getAllTaskByExecutor(@PathVariable Long id ){
        return taskMapper.mapToEntity(taskService.getAllTaskByExecutor(id));

    }
    @PreAuthorize("hasAnyAuthority('USER_ROLE')")
    @PatchMapping("/api/task/update")
    public TaskResponseDto updateTask(@Valid @RequestBody TaskUpdateByUserRequestDto taskUpdateByUserRequestDto) {

        TaskEntity taskEntity = taskService.updateTaskByUser(
                taskUpdateByUserRequestDto.getId(),
                taskUpdateByUserRequestDto.getUserId(),
                taskUpdateByUserRequestDto.getTaskStatus());

        return taskMapper.mapToDto(taskEntity);
    }



}
