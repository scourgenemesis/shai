package backend.shai.controller;

import backend.shai.dto.UserDto;
import backend.shai.model.User;
import backend.shai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById();
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto, MultipartFile avatarUrl) throws IOException {
        return userService.registerUser(userDto, avatarUrl);
    }

    @PostMapping
    public void updateAvatar(@RequestBody Long userId,MultipartFile avatarUrl) {
        userService.updateAvatar(userId, String.valueOf(avatarUrl));
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String username) {
        return userService.searchUsers(username);
    }

}
