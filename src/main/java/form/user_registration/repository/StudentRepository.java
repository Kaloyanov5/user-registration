package form.user_registration.repository;

import form.user_registration.model.Student;
import form.user_registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByUser(User user);
}
