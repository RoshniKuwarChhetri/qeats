package com.jsp.qeats.service;

import com.jsp.qeats.dto.RegisterRequest;
import com.jsp.qeats.dto.UserResponse;
import com.jsp.qeats.entity.Role;
import com.jsp.qeats.entity.User;
import com.jsp.qeats.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest registerRequest) {

        User user = new User();

        user.setUserName(registerRequest.getName());
        user.setEMail(registerRequest.getEMail());
        user.setPassword(registerRequest.getPassword());
        user.setRole(Role.CUSTOMER);

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return mapToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Integer id, RegisterRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setUserName(request.getName());
        user.setEMail(request.getEMail());
        user.setPassword(request.getPassword());

        User updatedUser = userRepository.save(user);

        return mapToResponse(updatedUser);
    }

    @Override
    public String deleteUser(Integer id) {

        userRepository.deleteById(id);

        return "User Deleted Successfully";
    }

    private UserResponse mapToResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getEMail(),
                user.getRole()
        );
    }
}