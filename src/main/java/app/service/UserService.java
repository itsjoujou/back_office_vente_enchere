package app.service;

import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(User user, int typeUser) {
        userRepository.generateToken(user.getUsername(), user.getPassword());
        Optional<User> optionalUser = userRepository.authenticateUserWithUsernameAndHashedPassword(user.getUsername(), user.getPassword(), typeUser);

        return optionalUser.orElse(null);
    }
}
