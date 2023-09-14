package com.hsk.taskservice.service;

import com.hsk.taskservice.persistent.entity.Task;

public interface TaskService {
    Task addTask(Long projectId, Task task);

    Task getTaskById(Long taskId);

    Task updateTaskById(Long taskId, Task task);

    Task deleteTaskById(Long taskId);


}
