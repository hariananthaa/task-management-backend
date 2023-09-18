package com.hsk.projectservice.service;

import com.hsk.projectservice.persistent.entity.Project;

import java.util.List;

public interface ProjectService {
    Project addProject(Project project);

    Project getProjectById(Long projectId);
    Project getProjectByKey(String projectKey);

    Project updateProjectById(Long projectId, Project project);

    Project deleteProjectById(Long projectId);

    List<Project> getAllProjects();
}
