package backend.shai.service;

import backend.shai.model.User;
import backend.shai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User registerUser(User user) {
        if (userRepo.exists(user.getUsername())) {

        }
    }

}
