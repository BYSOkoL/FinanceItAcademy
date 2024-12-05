package by.itacademy.userservice.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RestTemplate restTemplate;

    public UserDetailsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Здесь мы делаем запрос в user-service для получения информации о пользователе
        String url = "http://localhost:8081/api/v1/users/" + username;
        UserResponse userResponse = restTemplate.getForObject(url, UserResponse.class);

        if (userResponse == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        return new UserDetailsImpl(userResponse);
    }
}