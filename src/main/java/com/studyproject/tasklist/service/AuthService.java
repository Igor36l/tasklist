package com.studyproject.tasklist.service;

import com.studyproject.tasklist.web.dto.auth.*;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);


    JwtResponse refresh(String refreshToken);
}
