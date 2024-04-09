package com.studyproject.tasklist.web.mappers;

import com.studyproject.tasklist.domain.user.User;
import com.studyproject.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto Dto);
}
