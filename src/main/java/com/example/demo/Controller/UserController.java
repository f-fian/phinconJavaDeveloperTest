package com.example.demo.Controller;

import com.example.demo.Dto.UpdateUserDto;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatusCode.valueOf(200));
    }
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDto updateUserDto,@PathVariable("id") Integer id){

        return new ResponseEntity<>(userService.updateUser(updateUserDto,id),
                HttpStatusCode.valueOf(201));
    }
    @DeleteMapping("users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}
