package com.hsk.projectservice.web;

import com.hsk.projectservice.helper.TaskHelper;
import com.hsk.projectservice.utils.ResponseData;
import com.hsk.projectservice.web.payload.GetAllTaskRequest;
import com.hsk.projectservice.web.payload.TaskRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false") // TODO: remove this in PROD ENV
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

    @GetMapping("/{taskId}")
    public ResponseData getTaskById(
            @PathVariable("taskId") Long taskId
    ){
        return taskHelper.getTaskById(taskId);
    }

    @GetMapping
    public ResponseData getTasksById(
            @Valid
            @RequestParam("projectKey")
            @NotBlank(message = "Project key is required.")
            @Pattern(regexp = "^[A-Z]+(-[A-Z]+)*$",message = "Key must contains only alphabets.")
            String projectKey
    ){
        return taskHelper.getTasksByProjectKey(projectKey);
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

    @DeleteMapping("/{taskId}")
    public ResponseData deleteTaskById(
            @PathVariable("taskId") Long taskId
    ){
        return taskHelper.deleteTaskById(taskId);
    }

}
