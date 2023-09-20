package com.hsk.projectservice.web;

import com.hsk.projectservice.helper.ProjectHelper;
import com.hsk.projectservice.utils.ResponseData;
import com.hsk.projectservice.web.payload.ProjectRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Order(1)
@RequestMapping("/api/v1/projects")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false") // TODO: remove this in PROD ENV
public class ProjectController {

    private final ProjectHelper projectHelper;

    public ProjectController(ProjectHelper projectHelper) {
        this.projectHelper = projectHelper;
    }

    @PostMapping
    public ResponseData addProject(
            @Valid
            @RequestBody
            ProjectRequest projectRequest,
            BindingResult bindingResult
    ){
        return projectHelper.addProject(projectRequest,bindingResult);
    }

    @GetMapping("/{projectId}")
    public ResponseData getProjectById(
            @PathVariable("projectId") Long projectId
    ){
        return projectHelper.getProjectById(projectId);
    }

    @PutMapping("/{projectId}")
    public ResponseData updateProjectById(
            @PathVariable("projectId") Long projectId,
            @Valid
            @RequestBody
            ProjectRequest projectRequest,
            BindingResult bindingResult
    ){
        return projectHelper.updateProjectById(projectId,projectRequest,bindingResult);
    }

    @DeleteMapping("/{projectId}")
    public ResponseData deleteProjectById(
            @PathVariable("projectId") Long projectId
    ){
        return projectHelper.deleteProjectById(projectId);
    }

    @GetMapping
    public ResponseData getAllProjects(){
        return projectHelper.getAllProjects();
    }
}
