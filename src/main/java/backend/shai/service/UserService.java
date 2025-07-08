package backend.shai.service;

import backend.shai.model.User;
import backend.shai.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User registerUser(@NotNull User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username taken!");
        }
        
    }

    public User deteleUser(User user) {

    }

}
