package form.user_registration.service;

import form.user_registration.request.LoginRequest;
import form.user_registration.request.RegistrationRequest;
import form.user_registration.model.User;
import form.user_registration.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> register(RegistrationRequest request) {
        if (userRepository.findUserByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match!");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    public ResponseEntity<?> login(LoginRequest request) {
        if (userRepository.findUserByUsername(request.getUsername()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username does not exist!");
        }

        User user = userRepository.findUserByUsername(request.getUsername()).get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password!");
        }

        return ResponseEntity.ok(user.getId());
    }
}
