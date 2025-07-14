package backend.shai.service;


import backend.shai.dto.LoginRequest;
import backend.shai.dto.UserRequest;
import backend.shai.model.User;
import backend.shai.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthenticationToken jwtAuthenticationToken;

    @Transactional
    public User registerUser(@NotNull UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepo.save(userRequest);
    }

    @Transactional
    public String login(LoginRequest loginRequest) {
        User user = userRepo.existsByUsername(loginRequest.getUsername());
    }
}
