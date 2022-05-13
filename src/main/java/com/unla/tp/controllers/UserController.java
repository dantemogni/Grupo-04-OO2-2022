package com.unla.tp.controllers;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.models.UserSignUpRequest;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView(ViewRouteHelper.USER_LOGIN);
    }

    @GetMapping(value = "/register")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);
        modelAndView.addObject("userSignUpRequest", new UserSignUpRequest());
        return modelAndView;
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/index";
    }

}
