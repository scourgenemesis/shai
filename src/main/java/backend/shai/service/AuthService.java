package backend.shai.service;


import backend.shai.dto.UserRequest;
import backend.shai.model.User;
import backend.shai.repository.UserRepository;
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

    public User registerUser(UserRequest userRequest) {
        
    }
}
