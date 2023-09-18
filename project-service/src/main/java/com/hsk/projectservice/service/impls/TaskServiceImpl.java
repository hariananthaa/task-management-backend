package com.hsk.projectservice.service.impls;

import com.hsk.projectservice.mapper.TaskMapper;
import com.hsk.projectservice.persistent.entity.Project;
import com.hsk.projectservice.persistent.entity.Task;
import com.hsk.projectservice.persistent.repository.TaskRepository;
import com.hsk.projectservice.service.ProjectService;
import com.hsk.projectservice.service.TaskService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            ProjectService projectService,
            TaskMapper taskMapper
    ) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(()->new NotFoundException("Task not found."));
    }

    @Override
    public List<Task> getTasksByProjectKey(String projectKey) {
        return taskRepository.findAllByProject_Key(projectKey);
    }

    @Override
    public Task updateTaskById(Long taskId, Task task) {
        Task existingTask = getTaskById(taskId);
        existingTask = taskMapper.partialUpdate(task,existingTask);
        return taskRepository.saveAndFlush(existingTask);
    }

    @Override
    public Task deleteTaskById(Long taskId) {
        Task existingTask = getTaskById(taskId);
        taskRepository.deleteById(taskId);
        return existingTask;
    }

    @Override
    public Task addTask(String projectKey, Task task) {
        Project project = projectService.getProjectByKey(projectKey);
        task.setStatus("Open");
        task.setProject(project);
        return taskRepository.save(task);
    }
}
