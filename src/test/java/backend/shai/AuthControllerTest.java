package backend.shai;

import backend.shai.controller.AuthController;
import backend.shai.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController)
                .defaultRequest(post("/").with(csrf())) // Apply CSRF to all requests
                .build();
    }

    @Test
    @WithMockUser
    public void testValidRegistration() throws Exception {
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "username": "testuser",
                                    "password": "SecurePass123!"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered!"));
    }

    @Test
    @WithMockUser
    public void testDuplicateUsername() throws Exception {
        when(authService.registerUser(any()))
                .thenThrow(new RuntimeException("Username already exists"));

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "username": "alice",
                                    "password": "NewPassword456!"
                                }
                                """))
                .andExpect(status().isConflict());
    }
}