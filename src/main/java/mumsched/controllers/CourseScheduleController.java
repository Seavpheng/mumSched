package mumsched.controllers;

import mumsched.domain.CourseSchedule;
import mumsched.services.BlockService;
import mumsched.services.CourseScheduleService;
import mumsched.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/course_schedules")
@Controller
public class CourseScheduleController {

    @Autowired
    CourseScheduleService courseScheduleService;
    @Autowired
    CourseService courseService;
    @Autowired
    BlockService blockService;

    @GetMapping("/list")
    public ModelAndView getList()
    {
        ModelAndView mav = new ModelAndView("course_schedule/list");
        mav.addObject("courseSchedules",courseScheduleService.getCourseSchedules());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("course_schedule/create");

        mav.addObject("blocks",blockService.getBlocks());
        mav.addObject("courses",courseService.getCourses());
        return mav;
    }
    @PostMapping("/create")
    public ModelAndView create(CourseSchedule courseSchedule){

        courseScheduleService.Create(courseSchedule);

//        ModelAndView mav = new ModelAndView("course_schedule/create");
//        mav.addObject("blocks",blockService.getBlocks());
//        mav.addObject("courses",courseService.getCourses());
        return getList();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long courseId){
        ModelAndView mav = new ModelAndView("course_schedule/edit");
        mav.addObject("courseSchedule", courseScheduleService.getCourseSchedule(courseId));

        mav.addObject("blocks",blockService.getBlocks());
        mav.addObject("courses",courseService.getCourses());
        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView edit(CourseSchedule courseSchedule){
        courseScheduleService.Update(courseSchedule);

        return getList();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long courseId ){
         courseScheduleService.delete(courseId);
        return getList();
    }
}
