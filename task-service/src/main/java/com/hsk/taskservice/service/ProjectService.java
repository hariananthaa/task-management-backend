package com.hsk.taskservice.service;

import com.hsk.taskservice.persistent.entity.Project;

public interface ProjectService {
    Project addProject(Project project);

    Project getProjectById(Long projectId);

    Project updateProjectById(Long projectId, Project project);

    Project deleteProjectById(Long projectId);
}
