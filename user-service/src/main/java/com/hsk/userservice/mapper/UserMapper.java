package com.hsk.userservice.mapper;

import com.hsk.userservice.web.payload.UserSignupRequest;
import com.hsk.userservice.dto.UserDto;
import com.hsk.userservice.persistent.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDto userDto);
    User toEntity(UserSignupRequest userSignupRequest);

    UserDto toDto(User user);
    List<UserDto> toDto(List<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}