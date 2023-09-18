package com.hsk.projectservice.mapper;

import com.hsk.projectservice.dto.ProjectDto;
import com.hsk.projectservice.dto.TaskDto;
import com.hsk.projectservice.persistent.entity.Project;
import com.hsk.projectservice.persistent.entity.Task;
import com.hsk.projectservice.web.payload.TaskRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    Task toEntity(TaskRequest taskRequest);

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(Task task, @MappingTarget Task existingtask);

}