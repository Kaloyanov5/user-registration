package form.user_registration.service;

import form.user_registration.model.RegistrationRequest;
import form.user_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> register(RegistrationRequest request) {
        return ResponseEntity.ok("test");
    }
}
