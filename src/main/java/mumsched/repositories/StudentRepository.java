package mumsched.repositories;

import mumsched.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findStudentById(Long id);
}
