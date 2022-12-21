package mumsched.controllers;

import mumsched.domain.Faculty;
import mumsched.domain.Student;
import mumsched.services.FacultyService;
import mumsched.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/list")
    public ModelAndView getFacultyList(){
        System.out.print( facultyService.getAll());
        ModelAndView mav = new ModelAndView("faculty/list");


        mav.addObject("faculties", facultyService.getAll());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createFaculty(Faculty faculty, Model model){
        Faculty fac = new Faculty(faculty.getFirstName(), faculty.getLastName());
        facultyService.Save(fac);

        ModelAndView mav = new ModelAndView("faculty/success");
        mav.addObject("faculty", fac);
        return mav;
    }

    @GetMapping("/create")
    public String create(Faculty faculty, Model model){
        model.addAttribute( faculty);
        return "faculty/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long facultyId){
        ModelAndView mav = new ModelAndView("faculty/edit");
        mav.addObject("faculty", facultyService.getFaculty(facultyId));
        return mav; //"student/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit(Faculty faculty){
        facultyService.Save(faculty);
        ModelAndView mav = new ModelAndView("faculty/edit");
        mav.addObject("faculty", facultyService.getFaculty(faculty.getId()));
        return mav; //"student/edit";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long studentId){
        facultyService.delete(studentId);
        return getFacultyList();
    }
}
