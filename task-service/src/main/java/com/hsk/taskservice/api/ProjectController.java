package com.hsk.taskservice.api;

import com.hsk.taskservice.api.payload.ProjectRequest;
import com.hsk.taskservice.helper.ProjectHelper;
import com.hsk.taskservice.utils.ResponseData;
import com.hsk.taskservice.utils.ResponseUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectHelper projectHelper;

    public ProjectController(ProjectHelper projectHelper) {
        this.projectHelper = projectHelper;
    }

    @PostMapping
    public ResponseData addProject(
            @RequestBody
            ProjectRequest projectRequest,
            BindingResult bindingResult
    ){
        return projectHelper.addProject(projectRequest,bindingResult);
    }
}
