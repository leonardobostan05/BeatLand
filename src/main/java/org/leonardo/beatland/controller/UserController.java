package org.leonardo.beatland.controller;

import org.leonardo.beatland.entity.User;
import org.leonardo.beatland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // RequestBody liest den JSON aus dem body und wandelt ihn in Java um (User Objekt)
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //extrahiert den Wert aus der URL raus und arbeitet damit
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
