package form.user_registration.service;

import form.user_registration.model.Student;
import form.user_registration.model.User;
import form.user_registration.repository.StudentRepository;
import form.user_registration.repository.UserRepository;
import form.user_registration.request.StudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> getStudents(Long user_id) {
        if (!userRepository.findById(user_id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this id was not found!");
        }

        User user = userRepository.findById(user_id).get();

        return ResponseEntity.ok(studentRepository.findStudentsByUser(user));
    }

    public ResponseEntity<?> addStudent(StudentRequest request, Long user_id) {
        if (!userRepository.findById(user_id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this id does not exist!");
        }
        User user = userRepository.findById(user_id).get();
        Student student = new Student(
                request.getFullName(),
                request.getAge(),
                request.getPhoneNumber(),
                request.getAddress(),
                user
        );
        studentRepository.save(student);
        return ResponseEntity.ok("Student saved successfully!");
    }
}
