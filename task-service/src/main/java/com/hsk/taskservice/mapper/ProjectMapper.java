package com.hsk.taskservice.mapper;

import com.hsk.taskservice.dto.ProjectDto;
import com.hsk.taskservice.persistent.entity.Project;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TaskMapper.class})
public interface ProjectMapper {
    Project toEntity(ProjectDto projectDto);

    @AfterMapping
    default void linkTask(@MappingTarget Project project) {
        project.getTask().forEach(task -> task.setProject(project));
    }

    ProjectDto toDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(Project project, @MappingTarget Project existingProject);
}