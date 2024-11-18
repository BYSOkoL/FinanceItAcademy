package by.itacademy.userservice.storage;



import by.itacademy.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStorage extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // loadByUsername
}