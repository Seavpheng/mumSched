package mumsched.repositories;

import mumsched.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    //List<Course> getCourses();
    Course findCourseById(Long id);

    boolean existsCourseByCourseName(String courseName);

    @Query("SELECT CASE WHEN COUNT(c.id) > 0 THEN true ELSE false END  " +
            "FROM Course c WHERE LOWER(c.courseName) LIKE LOWER(?1) AND c.id <> ?2")
    boolean checksExistOnUpdate(String courseName, Long id);


}
