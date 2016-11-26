package com.dr3amers.controller;

import com.dr3amers.model.AuthenticatedUser;
import com.dr3amers.model.User;
import com.dr3amers.repository.UserJpaRepository;
import com.dr3amers.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserJpaRepository userJpaRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public AuthenticatedUser registerNewAccount(@Valid User user){
        return authenticationService.registerNewAccount(user);
    }

    @RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") int id){
        return userJpaRepository.findOne(id);
    }



}
