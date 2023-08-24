package com.example.demo.Service;


import com.example.demo.Dto.UpdateUserDto;
import com.example.demo.Exeption.UserNotFoundExeption;
import com.example.demo.Model.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    public User getUser(Integer id){
        return userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundExeption("user is not found"));
    }
    public User updateUser(UpdateUserDto updateUserData,Integer id){
        User userData = userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundExeption("User Id is not found"));

        if(! passwordEncoder.matches(updateUserData.old_password(),userData.getPassword())){
            throw new UserNotFoundExeption("your old password is wrong");
        }
        userData.setPassword(passwordEncoder.encode(updateUserData.new_password()));
        userData.setUsername(updateUserData.username());
        userRepo.save(userData);
        return userData;

    }
    public void deleteUser(Integer id){
        userRepo.deleteById(id);
    }
}
