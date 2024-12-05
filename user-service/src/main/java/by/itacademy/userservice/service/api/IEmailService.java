package by.itacademy.userservice.service.api;

public interface IEmailService {
    void sendEmail(String to, String subject, String text);
}
