package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.UserService;
import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.model.UserNoRegister;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8081
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/unregistered")
    public UserNoRegister saveUserNotRegister(@RequestBody UserNoRegister userNoRegister){
        return userService.saveNoRegisterUser(userNoRegister);
    }
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/{dni}")
    public User findByDNI(@PathVariable String dni){

        return userService.findByDNI(dni);
    }


}
