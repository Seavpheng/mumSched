package mumsched.controllers;

import mumsched.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String create(@RequestParam String username, @RequestParam String password){

        return userService.save(username, password).toString();
    }

    @GetMapping("/get")
    public String getMe(){
        return "Hello User";
    }
}
