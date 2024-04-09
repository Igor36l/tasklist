package com.studyproject.tasklist.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.studyproject.tasklist.domain.task.Task;
import com.studyproject.tasklist.domain.user.Role;
import com.studyproject.tasklist.web.dto.validation.OnCreate;
import com.studyproject.tasklist.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String Name;

    @NotNull(message = "UserName must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "UserName length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "Confirmation must be not null", groups =  OnUpdate.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;

}
