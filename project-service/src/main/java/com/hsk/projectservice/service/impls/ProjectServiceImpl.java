package com.hsk.projectservice.service.impls;

import com.hsk.projectservice.mapper.ProjectMapper;
import com.hsk.projectservice.persistent.entity.Project;
import com.hsk.projectservice.persistent.repository.ProjectRepository;
import com.hsk.projectservice.service.ProjectService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(()->new NotFoundException("Project not found."));
    }

    @Override
    public Project updateProjectById(Long projectId, Project project) {
        Project existingProject = getProjectById(projectId);
        existingProject = projectMapper.partialUpdate(project,existingProject);
        return projectRepository.saveAndFlush(existingProject);
    }

    @Override
    public Project deleteProjectById(Long projectId) {
        Project project = getProjectById(projectId);
        projectRepository.deleteById(projectId);
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
