package com.hsk.projectservice.service;

import com.hsk.projectservice.persistent.entity.Task;

import java.util.List;

public interface TaskService {

    Task getTaskById(Long taskId);
    List<Task> getTasksByProjectKey(String projectKey);

    Task updateTaskById(Long taskId, Task task);

    Task deleteTaskById(Long taskId);

    Task addTask(String projectKey, Task task);
}
