package com.hsk.taskservice.mapper;

import com.hsk.taskservice.web.payload.TaskRequest;
import com.hsk.taskservice.dto.TaskDto;
import com.hsk.taskservice.persistent.entity.Task;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    Task toEntity(TaskDto taskDto);
    Task toEntity(TaskRequest taskRequest);

    TaskDto toDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(Task task, @MappingTarget Task existingtask);

}