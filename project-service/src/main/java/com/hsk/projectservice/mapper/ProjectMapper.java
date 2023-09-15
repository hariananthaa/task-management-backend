package com.hsk.projectservice.mapper;

import com.hsk.projectservice.dto.ProjectDto;
import com.hsk.projectservice.persistent.entity.Project;
import com.hsk.projectservice.web.payload.ProjectRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectRequest projectRequest);

    ProjectDto toDto(Project project);
    List<ProjectDto> toDto(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(Project project, @MappingTarget Project existingProject);
}