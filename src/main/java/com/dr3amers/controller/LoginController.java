package com.dr3amers.controller;

import com.dr3amers.model.AuthenticatedUser;
import com.dr3amers.model.User;
import com.dr3amers.repository.UserJpaRepository;
import com.dr3amers.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/account")
public class LoginController {

    private AuthenticationService authenticationService;
    private UserJpaRepository userJpaRepository;

    @Autowired
    public LoginController (AuthenticationService authenticationService, UserJpaRepository userJpaRepository) {
        this.authenticationService = authenticationService;
        this.userJpaRepository = userJpaRepository;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        //TODO redirect to login page
        return new ResponseEntity<>("Вы сходили нахуй успешно. Поздраляю!", HttpStatus.OK);
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView model = new ModelAndView("register");
        model.addObject("title", "Admministrator Control Panel");
        model.addObject("message", "This page demonstrates how to use Spring security.");

        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AuthenticatedUser registerNewAccount(User user){
        return authenticationService.registerNewAccount(user);
    }

    //fake code that won't be released
    @RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") int id){
        return userJpaRepository.findOne(id);
    }
}
