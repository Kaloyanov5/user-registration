package form.user_registration.controller;

import form.user_registration.request.StudentRequest;
import form.user_registration.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{user_id}")
    public ResponseEntity<?> getUserStudents(@PathVariable Long user_id) {
        return studentService.getStudents(user_id);
    }

    @PostMapping("/students/{user_id}")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest request, @PathVariable Long user_id) {
        return studentService.addStudent(request, user_id);
    }
}
