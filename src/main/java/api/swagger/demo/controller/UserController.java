package api.swagger.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import api.swagger.demo.model.User;
import api.swagger.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUsers(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getUserss() {
        return service.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUsers(@PathVariable String userId){
        return service.getUserByUserId(userId);
    }

    @PutMapping
    public User modifyUsers(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUsers(@PathVariable String userId){
        return service.deleteUser(userId);
    }
}
