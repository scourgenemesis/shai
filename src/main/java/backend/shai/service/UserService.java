package backend.shai.service;

import backend.shai.dto.UserRequest;
import backend.shai.model.User;
import backend.shai.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FileStorageService fileStorageService;

    public User registerUser(@NotNull UserRequest userRequest, MultipartFile avatarFile) throws IOException {
        if (userRepo.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("Username taken!");
        }

        User user = new User();
        user.setUsername(userRequest.getUsername());

        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        if (avatarFile != null && !avatarFile.isEmpty()) {
            String avatarUrl = fileStorageService.storeFile(avatarFile);
        }
        else {
            user.setAvatarUrl("/default-avatar.png");
        }

        return userRepo.save(user);
    }

    public void updateAvatar(Long userId, String avatarUrl) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setAvatarUrl(avatarUrl);
        userRepo.save(user);
    }
    

//    public User deteleUser(User user) {
//
//    }

}
