package com.jsp.qeats.controller;

import com.jsp.qeats.dto.RegisterRequest;
import com.jsp.qeats.dto.UserResponse;
import com.jsp.qeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // CREATE USER
    @PostMapping
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest registerRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(registerRequest));
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer id,
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                userService.updateUser(id, request)
        );
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                userService.deleteUser(id)
        );
    }
}