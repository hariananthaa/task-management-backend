package com.hsk.taskservice.api;

import com.hsk.taskservice.api.payload.TaskRequest;
import com.hsk.taskservice.helper.TaskHelper;
import com.hsk.taskservice.utils.ResponseData;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskHelper taskHelper;

    public TaskController(TaskHelper taskHelper) {
        this.taskHelper = taskHelper;
    }

    @PostMapping
    public ResponseData addTask(
            @Valid
            @RequestBody
            TaskRequest taskRequest,
            BindingResult bindingResult
    ){
        return taskHelper.addTask(taskRequest,bindingResult);
    }

    @PutMapping("/{taskId}")
    public ResponseData updateTaskById(
            @PathVariable("taskId") Long taskId,
            @Valid
            @RequestBody
            TaskRequest taskRequest,
            BindingResult bindingResult
    ){
        return taskHelper.updateTaskById(taskId, taskRequest,bindingResult);
    }

    @GetMapping("/{taskId}")
    public ResponseData getTaskById(
            @PathVariable("taskId") Long taskId
    ){
        return taskHelper.getTaskById(taskId);
    }

    @DeleteMapping("/{taskId}")
    public ResponseData deleteTaskById(
            @PathVariable("taskId") Long taskId
    ){
        return taskHelper.deleteTaskById(taskId);
    }

}
