package com.unla.tp.models.validator;

import java.util.regex.Pattern;

import com.unla.tp.models.UserSignUpRequest;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserSignUpRequestValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserSignUpRequestValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserSignUpRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserSignUpRequest form = (UserSignUpRequest) target;

        notBlankValues(errors, form);
        validateUsername(errors, form);
        patternMatches(errors, form);
    }

    private void notBlankValues(Errors errors, UserSignUpRequest form) {
        if (form.getNombre().isBlank())
            errors.rejectValue("nombre", "blankName", "Introduzca un nombre");

        if (form.getApellido().isBlank())
            errors.rejectValue("apellido", "blankApellido", "Introduzca un apellido");

        if (form.getEmail().isBlank())
            errors.rejectValue("email", "blankEmail", "Introduzca un mail");

        if (form.getNroDocumento() == null || form.getNroDocumento().isNaN())
            errors.rejectValue("nroDocumento", "blankNroDocumento", "Introduzca un numero");

        if (form.getPassword().isBlank())
            errors.rejectValue("password", "blankPassword", "Introduzca un contraseña");

        if (form.getUsername().isBlank())
            errors.rejectValue("username", "blankUsername", "Introduzca un nombre de usuario");
    }

    private void validateUsername(Errors errors, UserSignUpRequest form) {
        try {
            if (userService.loadUserByUsername(form.getUsername()) != null) {
                errors.rejectValue("username", "userExists",
                        "Ya existe un registro con este usuario");
            }
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void patternMatches(Errors errors, UserSignUpRequest form) {

        if (!(Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(form.getEmail())
                .matches())) {
            errors.rejectValue("email", "wrongMail", "Mail no valido");
        }
    }
}
