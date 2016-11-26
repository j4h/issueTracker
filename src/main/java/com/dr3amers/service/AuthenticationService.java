package com.dr3amers.service;

import com.dr3amers.exception.EmailExistsException;
import com.dr3amers.model.AuthenticatedUser;
import com.dr3amers.model.User;
import com.dr3amers.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements UserDetailsService {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public AuthenticationService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        User user = userJpaRepository.findByNickname(nickname);
        if (user == null) {
            throw new UsernameNotFoundException("There is no user with nickname "+ nickname);
        }
        return new AuthenticatedUser(user);
    }

    public AuthenticatedUser registerNewAccount(User user) throws EmailExistsException {

        if (user != null) {
            userJpaRepository.saveAndFlush(user);
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
            Authentication authentication = new UsernamePasswordAuthenticationToken(authenticatedUser, null,
                    new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authenticatedUser;
        }
        return null;
    }
}
