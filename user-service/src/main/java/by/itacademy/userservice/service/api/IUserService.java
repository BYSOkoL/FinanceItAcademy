package by.itacademy.userservice.service.api;

import by.itacademy.userservice.entity.User;

import java.util.List;

public interface IUserService {
    User save(User user);
    User findByUsername(String username);
    List<User> findAll();

}