package com.hsk.taskservice.service.impls;

import com.hsk.taskservice.mapper.TaskMapper;
import com.hsk.taskservice.persistent.entity.Task;
import com.hsk.taskservice.persistent.repository.TaskRepository;
import com.hsk.taskservice.service.TaskService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task addTask(Task task) {
        task.setStatus("Open");
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
