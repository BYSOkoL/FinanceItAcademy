package by.itacademy.userservice.service.api;

import by.itacademy.userservice.dto.UserCreateRequest;
import by.itacademy.userservice.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User createUser(UserCreateRequest userCreateRequest);
    String verifyUser(String code, String mail);
    List<User> getAllUsers();
    User getUserById(UUID uuid);
    User updateUser(UUID uuid, long dt_update, UserCreateRequest userCreateRequest);

}
