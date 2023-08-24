package com.example.demo.Service;

import com.example.demo.Dto.TokenDto;
import com.example.demo.Exeption.BookNotFoundExption;
import com.example.demo.Exeption.UserNotFoundExeption;
import com.example.demo.Model.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterLoginService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public TokenDto login(User user){
        User userData = userRepo.findByUsername(user.getUsername())
                .orElseThrow(()-> new UserNotFoundExeption("username is not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        return new TokenDto(jwtService.generateToken(user));
    }
}
