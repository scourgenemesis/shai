package backend.shai.dto;

import backend.shai.model.User;

public class UserResponse extends User{
    private Long id;
    private String username;


    public UserResponse(User user) {
        this.id = id;
        this.username = username;
    }
}
