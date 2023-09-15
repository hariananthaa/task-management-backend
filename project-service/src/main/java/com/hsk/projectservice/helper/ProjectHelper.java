package com.hsk.projectservice.helper;

import com.hsk.projectservice.mapper.ProjectMapper;
import com.hsk.projectservice.persistent.entity.Project;
import com.hsk.projectservice.service.ProjectService;
import com.hsk.projectservice.utils.ResponseData;
import com.hsk.projectservice.utils.ResponseUtil;
import com.hsk.projectservice.web.payload.ProjectRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public class ProjectHelper {
    private final BindingResultHelper bindingResultHelper;
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectHelper(
            BindingResultHelper bindingResultHelper,
            ProjectService projectService,
            ProjectMapper projectMapper
    ) {
        this.bindingResultHelper = bindingResultHelper;
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    public ResponseData addProject(ProjectRequest projectRequest, BindingResult bindingResult) {
        bindingResultHelper.processBindingResult(bindingResult);
        Project project = projectService.addProject(projectMapper.toEntity(projectRequest));
        return ResponseUtil.responseConverter(projectMapper.toDto(project));
    }

    public ResponseData getProjectById(Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return ResponseUtil.responseConverter(projectMapper.toDto(project));
    }

    public ResponseData updateProjectById(
            Long projectId, ProjectRequest projectRequest,
            BindingResult bindingResult
    ) {
        bindingResultHelper.processBindingResult(bindingResult);
        Project project = projectService.updateProjectById(projectId,projectMapper.toEntity(projectRequest));
        return ResponseUtil.responseConverter(projectMapper.toDto(project));
    }

    public ResponseData deleteProjectById(Long projectId) {
        Project project = projectService.deleteProjectById(projectId);
        return ResponseUtil.responseConverter(projectMapper.toDto(project));
    }

    public ResponseData getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseUtil.responseConverter(projectMapper.toDto(projects));
    }
}
