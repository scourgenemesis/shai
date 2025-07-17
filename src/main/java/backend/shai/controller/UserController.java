package backend.shai.controller;

import backend.shai.dto.UserRequest;
import backend.shai.model.User;
import backend.shai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/users/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById();
//    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequest userRequest, MultipartFile avatarUrl) throws IOException {
        return userService.registerUser(userRequest, avatarUrl);
    }

    @PostMapping
    public void updateAvatar(@RequestBody Long userId,MultipartFile avatarUrl) {
        userService.updateAvatar(userId, String.valueOf(avatarUrl));
    }

    @GetMapping("/search")
    public Optional<User> searchUsers(@RequestParam String username) {
        return userService.searchUsers(username);
    }
}
