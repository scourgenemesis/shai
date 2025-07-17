package com.example.shai;


import backend.shai.dto.LoginRequest;
import backend.shai.dto.UserRequest;
import backend.shai.model.User;
import backend.shai.repository.UserRepository;
import backend.shai.service.AuthService;
import backend.shai.util.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private UserRepository userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    // ===== REGISTRATION TESTS =====
    @Test
    void registerUser_Success() {
        // Arrange
        UserRequest request = new UserRequest("testuser", "Password123!");
//        when(userRepo.existsByUsername("testuser")).thenReturn(false);
        when(passwordEncoder.encode("Password123!")).thenReturn("hashedPass");
        when(userRepo.save(any(User.class))).thenReturn(new User());

        // Act
        authService.registerUser(request);

        // Assert
        verify(userRepo).save(any(User.class));
    }

    @Test
    void loginUser_ValidCredentials() {
        // Arrange
        LoginRequest request = new LoginRequest("testUser", "Password123!");
        User mockUser = new User();
        mockUser.setUsername("testUser");
        mockUser.setPassword("hashedPass");

        when(userRepo.findByUsername("testUser")).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches("Password123!", "hashedPass")).thenReturn(true);
        when(jwtTokenProvider.generateToken("testUser")).thenReturn("mockJwtToken");

        // Act
        String token = authService.login(request);

        // Assert
        assertEquals("mockJwtToken", token);
    }

}
