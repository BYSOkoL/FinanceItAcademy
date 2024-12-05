package by.itacademy.userservice.controller;

import by.itacademy.userservice.dto.*;
import by.itacademy.userservice.model.User;
import by.itacademy.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(userCreateRequest);
        return ResponseEntity.status(201).body(new UserResponse(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(UserResponse.from(users));
    }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID uuid) {
        User user = userService.getUserById(uuid);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @PutMapping("/users/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable UUID uuid,
            @PathVariable long dt_update,
            @Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.updateUser(uuid, dt_update, userCreateRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @PostMapping("/cabinet/registration")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(userCreateRequest);
        return ResponseEntity.status(201).body(new UserResponse(user));
    }

    @GetMapping("/cabinet/verification")
    public ResponseEntity<String> verifyUser(@RequestParam String code, @RequestParam String mail) {
        // Implement verification logic here
        return ResponseEntity.ok("User verified successfully");
    }
}