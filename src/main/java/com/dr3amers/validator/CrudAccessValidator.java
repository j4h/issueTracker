package com.dr3amers.validator;

import com.dr3amers.helper.Helper;
import org.springframework.security.access.AccessDeniedException;

//Validation for Model CRUD operations
//TODO add if-clause for ROLE_ADMIN to have rights on this operations
public class CrudAccessValidator {

    public static Object modelUpdateValidation(Object o, int creatorId) {

        if (creatorId != Helper.getCurrentUser().getId())
            throw new AccessDeniedException("You have no rights to update this");

        return o;
    }

}
