package com.hsk.taskservice.helper;

import com.hsk.taskservice.web.payload.TaskRequest;
import com.hsk.taskservice.mapper.TaskMapper;
import com.hsk.taskservice.persistent.entity.Task;
import com.hsk.taskservice.service.TaskService;
import com.hsk.taskservice.utils.ResponseData;
import com.hsk.taskservice.utils.ResponseUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class TaskHelper {
    private final TaskMapper taskMapper;
    private final TaskService taskService;

    public TaskHelper(TaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    public ResponseData addTask(TaskRequest taskRequest, BindingResult bindingResult) {
        BindingResultHelper.processBindingResult(bindingResult);
        Task task = taskService.addTask(taskMapper.toEntity(taskRequest));
        return ResponseUtil.responseConverter(taskMapper.toDto(task));
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
}
