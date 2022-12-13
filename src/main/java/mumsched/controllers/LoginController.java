package mumsched.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller

public class LoginController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password){
        System.out.println("Here is it...");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ALREADY EXIST");
    }

}
