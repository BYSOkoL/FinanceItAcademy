package by.itacademy.userservice.controller;

import by.itacademy.userservice.dto.UserDTO;
import by.itacademy.userservice.entity.User;
import by.itacademy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//убрать api/v1 и прочую с nginx

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole("USER");

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
