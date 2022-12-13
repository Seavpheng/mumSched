package mumsched.controllers;


import mumsched.domain.Course;
import mumsched.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    public ModelAndView create(Course course){
        ResponseEntity result = courseService.Save(course);

        return getAll();
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("course/create");
        mav.addObject(new Course());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long courseId){
        ModelAndView mav = new ModelAndView("course/edit");
        mav.addObject("course", courseService.getCourseById(courseId));
        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Course course){
        boolean result = courseService.update(course);
        if(result == false){
            return edit(course.getId());
        }
        return getAll();
    }

    @GetMapping("/list")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("course/list");
        mav.addObject("courses",  courseService.getAll());
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long courseId ){
        courseService.delete(courseId);
        return getAll();
    }

}
