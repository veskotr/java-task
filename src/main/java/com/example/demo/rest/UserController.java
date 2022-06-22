package com.example.demo.rest;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.UserStatus;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin()
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers(){
        return this.userService.getAll();
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        return this.userService.getByEmail(email);
    }

    @PostMapping(path = "")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

   @PutMapping(path = "")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }
    @GetMapping("/by-status/{status}")
    public List<User> getUsersByStatus(@PathVariable UserStatus status){
        return this.userService.findAllByStatus(status);
    }

}
