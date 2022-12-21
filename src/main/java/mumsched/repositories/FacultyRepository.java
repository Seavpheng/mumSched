package mumsched.repositories;

import mumsched.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    Faculty findFacultyById(Long id);


}
