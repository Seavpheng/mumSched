package mumsched.controllers;

import mumsched.domain.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/entry")
@Controller
public class EntryController {

    @GetMapping("/create")
    public ModelAndView create( ){
        ModelAndView mav = new ModelAndView("entry/create");
        Entry entry = new Entry();
        mav.addObject("entry", entry);

        return mav;
    }
}
