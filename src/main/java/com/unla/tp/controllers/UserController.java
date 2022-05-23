package com.unla.tp.controllers;

import javax.validation.Valid;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.models.UserSignUpRequest;
import com.unla.tp.models.validator.UserSignUpRequestValidator;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView(ViewRouteHelper.USER_LOGIN);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/register")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);
        modelAndView.addObject("userSignUpRequest", new UserSignUpRequest());
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid UserSignUpRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);

        modelAndView.addObject("userSignUpRequest", user);

        UserSignUpRequestValidator uv = new UserSignUpRequestValidator(userService);
        uv.validate(user, bindingResult);

        // checks empty value errors
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        userService.createUser(user);
        modelAndView.addObject("successMessage", "Registro exitoso");

        return modelAndView;
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/index";
    }

}
