package backend.shai;

import backend.shai.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = Main.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidRegistration() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                        "username": "testuser",
                        "password": "SecurePass123!"
                    }
                    """))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testuser"));
    }

    @Test
    public void testDuplicateUsername() throws Exception {
        // First request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "username": "alice",
                        "password": "Password123!"
                    }
                    """));

        // Second request with same username
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                        "username": "alice",
                        "password": "NewPassword456!"
                    }
                    """))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }
}