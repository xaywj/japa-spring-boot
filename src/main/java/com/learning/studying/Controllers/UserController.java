package com.learning.studying.Controllers;

import com.learning.studying.Models.User;
import com.learning.studying.Services.BookService;
import com.learning.studying.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> index(){
        return this.userService.all();
    }
    @PostMapping()
    public User create(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable long id, @RequestBody User user){
        return this.userService.update(id,user);
    }
    @GetMapping("{id}")
    public User view(@PathVariable Long id){
        return this.userService.view(id);
    }
    @DeleteMapping("{id}")
    public User delete(@PathVariable Long id){
        return this.userService.delete(id);
    }
}
