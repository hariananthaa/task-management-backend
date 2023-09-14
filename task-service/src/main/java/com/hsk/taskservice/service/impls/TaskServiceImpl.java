package com.hsk.taskservice.service.impls;

import com.hsk.taskservice.mapper.TaskMapper;
import com.hsk.taskservice.persistent.entity.Project;
import com.hsk.taskservice.persistent.entity.Task;
import com.hsk.taskservice.persistent.repository.TaskRepository;
import com.hsk.taskservice.service.ProjectService;
import com.hsk.taskservice.service.TaskService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,ProjectService projectService, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task addTask(Long projectId, Task task) {
        task.setStatus("Open");
        Project project = projectService.getProjectById(projectId);
        List<Task> tasks = project.getTask();
        tasks.add(task);
        task.setProject(project);
        projectService.updateProjectById(projectId,project);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(()->new NotFoundException("Task not found."));
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
}
