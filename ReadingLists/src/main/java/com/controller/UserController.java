package com.controller;

import com.readinglists.com.Entity.User;
import com.readinglists.com.repository.UserRepository;
import com.service.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    SendMail sendMail;

    //User user = new User();
    @RequestMapping(value="/save",
    consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.POST
    )
    public void submitUserDetail(@RequestBody User user){
        userRepository.save(user);
        sendMail.send(user.getEmail(), "Registration Complete", "Thank you for creating an account.");
    }
    @RequestMapping(value = "/findUserByEmail", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity <User> findUser(String email){
        User user = userRepository.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> login (@RequestBody User user){
        User loginUser = userRepository.login(user.getEmail(), user.getPassword());
        if (loginUser != null){
            return new ResponseEntity<>(loginUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }




}
