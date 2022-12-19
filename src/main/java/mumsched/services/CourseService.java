package mumsched.services;

import mumsched.domain.Course;
import mumsched.repositories.CourseRepository;
import mumsched.repositories.CourseScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseScheduleRepository courseScheduleRepository;

    public ResponseEntity Save(Course course){
        Course obj = Course.createCourse(course.getCourseName());
        try {
            if(courseRepository.existsCourseByCourseName(obj.getCourseName()) ){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("ALREADY EXIST");
            }
            courseRepository.save(obj);
        }
        catch (Exception e)
        {

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(obj.toString());
    }

    public Course getCourseById(Long courseId){
        return courseRepository.findCourseById( courseId);
    }

    public boolean update(Course course) {
        try {
            if(courseRepository.checksExistOnUpdate(course.getCourseName(), course.getId())){
               return false;
            }
            courseRepository.save(course);
        }
        catch (Exception e)
        {
            throw e;
        }
        return true;
    }

    public ResponseEntity delete (Long courseId){
        try
        {
            if(courseScheduleRepository.CheckCourseInUsed(courseId)){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Course cannot be deleted because it is in used");
            }

            Course course = getCourseById(courseId);
            courseRepository.delete(course);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete successfully");
        }catch(Exception ex){
            throw  ex;
        }

    }

    public Iterable<Course> getCourses(){
        return courseRepository.findAll();
    }
}
