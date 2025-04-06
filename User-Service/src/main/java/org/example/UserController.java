package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String saveUser(@RequestBody User user){
       return userService.saveuser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return  userService.login(loginDTO);
    }



}
