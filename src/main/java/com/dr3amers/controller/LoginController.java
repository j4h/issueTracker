package com.dr3amers.controller;

import com.dr3amers.model.User;
import com.dr3amers.model.form.LoginForm;
import com.dr3amers.service.AuthenticationService;
import com.dr3amers.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account")
public class LoginController {

    private final AuthenticationService authenticationService;
    private final RegistrationValidator registrationValidator;

    @Autowired
    public LoginController (AuthenticationService authenticationService, RegistrationValidator registrationValidator) {
        this.authenticationService = authenticationService;
        this.registrationValidator = registrationValidator;
    }

    @GetMapping(value = "/login")
    public String signIn(LoginForm loginForm) {
        return "/login/loginForm";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);

        return "redirect:/login/loginForm";
    }

    @GetMapping(value = "/add")
    public String showRegistrationForm(User user) {
        return "/login/registerForm";
    }

    @PostMapping(value = "/add")
    public String registerNewAccount(@Valid User user, BindingResult bindingResult,
                                     Model model) {

        registrationValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "/login/registerForm";

        else {
            authenticationService.registerNewAccount(user);
            model.addAttribute("nickname", user.getNickname());
        }
        return "/login/registerSuccess";
    }

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registrationValidator);
    }*/
}