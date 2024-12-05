package by.itacademy.userservice.service;

import by.itacademy.userservice.dto.UserCreateRequest;
import by.itacademy.userservice.exception.UserNotFoundException;
import by.itacademy.userservice.model.User;
import by.itacademy.userservice.repository.UserRepository;
import by.itacademy.userservice.util.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordUtil passwordUtil;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, PasswordUtil passwordUtil, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordUtil = passwordUtil;
        this.emailService = emailService;
    }

    @Transactional
    public User createUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setMail(userCreateRequest.getMail());
        user.setFio(userCreateRequest.getFio());
        user.setPassword(passwordUtil.encode(userCreateRequest.getPassword()));
        user.setRole(userCreateRequest.getRole());
        user.setStatus("WAITING_ACTIVATION");
        user.setDt_create(System.currentTimeMillis());
        user.setDt_update(System.currentTimeMillis());
        String verificationCode = UUID.randomUUID().toString();
        user.setVerificationCode(verificationCode);
        user.setVerificationCodeExpiry(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        user = userRepository.save(user);
        sendVerificationEmail(user);
        return user;
    }

    public String verifyUser(String code, String mail) {
        User user = userRepository.findByMail(mail)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + mail));

        if (user.getVerificationCode() != null && user.getVerificationCode().equals(code) &&
                user.getVerificationCodeExpiry() != null && user.getVerificationCodeExpiry() > System.currentTimeMillis()) {
            user.setStatus("ACTIVATED");
            user.setVerificationCode(null); // Удаляем код после использования
            user.setVerificationCodeExpiry(null);
            userRepository.save(user);
            return "User verified successfully";
        } else {
            throw new RuntimeException("Invalid or expired verification code");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException("User not found with uuid: " + uuid));
    }

    @Transactional
    public User updateUser(UUID uuid, long dt_update, UserCreateRequest userCreateRequest) {
        User user = getUserById(uuid);
        if (user.getDt_update() != dt_update) {
            throw new RuntimeException("User has been updated concurrently");
        }
        user.setMail(userCreateRequest.getMail());
        user.setFio(userCreateRequest.getFio());
        user.setPassword(passwordUtil.encode(userCreateRequest.getPassword()));
        user.setRole(userCreateRequest.getRole());
        user.setStatus(userCreateRequest.getStatus());
        user.setDt_update(System.currentTimeMillis());
        return userRepository.save(user);
    }

    private void sendVerificationEmail(User user) {
        String verificationUrl = "http://localhost:8080/api/v1/cabinet/verification?code=" + user.getVerificationCode() + "&mail=" + user.getMail();
        String subject = "Email Verification";
        String text = "Please verify your email by clicking the following link: " + verificationUrl;

        emailService.sendEmail(user.getMail(), subject, text);
    }
}