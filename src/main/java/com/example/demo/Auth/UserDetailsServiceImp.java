package com.example.demo.Auth;

import com.example.demo.Exeption.UserNotFoundExeption;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailsServiceImp");
        System.out.println(username);
        return userRepo.findByUsername(username).map(UserDetailsImp::new)
                .orElseThrow(()->new UserNotFoundExeption("User Not Found"));
    }
}
