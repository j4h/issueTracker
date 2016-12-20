package com.dr3amers.validator;

import com.dr3amers.model.User;
import com.dr3amers.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        validateNickname(errors, (User) object);
    }

    private void validateNickname(Errors errors, User user) {

        if (userJpaRepository.findByNickname(user.getNickname()) != null) {
            errors.rejectValue("nickname", "nickname.already_exists");
        }
        if (userJpaRepository.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.already_exists");
        }
    }
}
