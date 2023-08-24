package com.example.demo.Controller;

import com.example.demo.Dto.TokenDto;
import com.example.demo.Model.User;
import com.example.demo.Service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterLoginController {

    @Autowired
    RegisterLoginService registerLoginService;


    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(registerLoginService.register(user), HttpStatusCode.valueOf(201));
    }

    @PostMapping("login")
    public ResponseEntity<TokenDto> login(@RequestBody User user){
        return new ResponseEntity<>(registerLoginService.login(user),HttpStatusCode.valueOf(200));
    }
}








