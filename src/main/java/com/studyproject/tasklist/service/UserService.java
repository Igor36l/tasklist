package com.studyproject.tasklist.service;

import com.studyproject.tasklist.domain.user.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    boolean isTaskOwner(Long UserId, Long TaskId);
    void delete(Long id);

}
