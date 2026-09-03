package com.example.identityService.controller;

import com.example.identityService.dto.request.ApiResponse;
import com.example.identityService.dto.request.UserCreationRequest;
import com.example.identityService.dto.request.UserUpdateRequest;
import com.example.identityService.dto.response.UserResponse;
import com.example.identityService.entity.User;
import com.example.identityService.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse <User> createUser (@RequestBody @Valid UserCreationRequest request) {
        ApiResponse <User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    ApiResponse <List<User>> getUsers() {
        ApiResponse <List<User>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUsers());

        return apiResponse;
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser (@PathVariable("userId") String userID) {

        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUser(userID));

        return apiResponse;
    }

    @PutMapping("/{userId}")
    ApiResponse <UserResponse> updateUser (@PathVariable ("userId") String userId, @RequestBody @Valid UserUpdateRequest request) {
        ApiResponse <UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.updateUser(userId, request));

        return apiResponse;
    }

    @DeleteMapping("/{userId}")
    String deleteUser (@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
