package mumsched.controllers;

import mumsched.domain.Student;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public ModelAndView getStudentList(){
        ModelAndView mav = new ModelAndView("student/list");
        mav.addObject("students", studentService.getAll());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(Student student, Model model){
        Student stu = new Student(student.getFirstName(), student.getLastName());
        studentService.Save(stu);

        ModelAndView mav = new ModelAndView("student/success");
        mav.addObject("student", stu);
        return mav;
    }

    @GetMapping("/create")
    public String create(Student student, Model model){
        model.addAttribute( student);
        return "student/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long studentId){
        ModelAndView mav = new ModelAndView("student/edit");

        System.out.println( studentService.getStudent(studentId));
        mav.addObject("student", studentService.getStudent(studentId));
        return mav; //"student/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit(Student student){
        System.out.println(student.getId());
        studentService.Save(student);

        return getStudentList(); //"student/edit";
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long studentId){
        studentService.delete(studentId);
        return getStudentList();
    }
}
