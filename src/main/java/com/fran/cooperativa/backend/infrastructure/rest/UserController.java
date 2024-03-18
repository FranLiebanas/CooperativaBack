package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.UserService;
import com.fran.cooperativa.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8081
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){

        return userService.findById(id);
    }


}
