package by.itacademy.userservice.dto;

import by.itacademy.userservice.model.User;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserResponse {

    private UUID uuid;
    private String mail;
    private String fio;
    private String role;
    private String status;
    private long dt_create;
    private long dt_update;

    public UserResponse(User user) {
        this.uuid = user.getUuid();
        this.mail = user.getMail();
        this.fio = user.getFio();
        this.role = user.getRole();
        this.status = user.getStatus();
        this.dt_create = user.getDt_create();
        this.dt_update = user.getDt_update();
    }

    public static List<UserResponse> from(List<User> users) {
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}