package com.jsp.qeats.service;

import com.jsp.qeats.dto.RegisterRequest;
import com.jsp.qeats.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse register(RegisterRequest registerRequest);

    UserResponse getUserById(Integer id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Integer id, RegisterRequest request);

    String deleteUser(Integer id);
}