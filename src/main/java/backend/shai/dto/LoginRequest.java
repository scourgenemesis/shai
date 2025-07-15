package backend.shai.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank private String username;
    @NotBlank private String passwd;

    public LoginRequest(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
