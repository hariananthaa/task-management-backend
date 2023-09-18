package com.hsk.projectservice.helper;

import com.hsk.projectservice.mapper.TaskMapper;
import com.hsk.projectservice.persistent.entity.Task;
import com.hsk.projectservice.service.TaskService;
import com.hsk.projectservice.utils.ResponseData;
import com.hsk.projectservice.utils.ResponseUtil;
import com.hsk.projectservice.web.payload.TaskRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public class TaskHelper {
    private final TaskMapper taskMapper;
    private final TaskService taskService;

    public TaskHelper(TaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    public ResponseData updateTaskById(Long taskId,
                                       TaskRequest taskRequest,
                                       BindingResult bindingResult) {
        BindingResultHelper.processBindingResult(bindingResult);
        Task task = taskService.updateTaskById(taskId,taskMapper.toEntity(taskRequest));
        return ResponseUtil.responseConverter(taskMapper.toDto(task));
    }

    public ResponseData getTaskById(Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return ResponseUtil.responseConverter(taskMapper.toDto(task));
    }

    public ResponseData deleteTaskById(Long taskId) {
        Task task = taskService.deleteTaskById(taskId);
        return ResponseUtil.responseConverter(taskMapper.toDto(task));
    }

    public ResponseData addTask(TaskRequest taskRequest, BindingResult bindingResult) {
        BindingResultHelper.processBindingResult(bindingResult);
        Task task = taskService.addTask(taskRequest.projectKey(), taskMapper.toEntity(taskRequest));
        return ResponseUtil.responseConverter(taskMapper.toDto(task));
    }

    public ResponseData getTasksByProjectKey(String projectKey) {
        List<Task> tasks = taskService.getTasksByProjectKey(projectKey);
        return ResponseUtil.responseConverter(taskMapper.toDto(tasks));
    }
}
