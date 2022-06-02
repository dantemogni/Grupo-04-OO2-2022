package com.unla.tp.controllers;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping(value = { "index", "/" })
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        com.unla.tp.entities.User userEntity = userService.getByUsername(userDetails.getUsername());

        modelAndView.addObject("username", userDetails.getUsername());
        modelAndView.addObject("nombre", userEntity.getNombre());
        modelAndView.addObject("apellido", userEntity.getApellido());

        modelAndView.addObject("userRole", userDetails.getAuthorities().stream().toArray()[0].toString());

        return modelAndView;
    }
}
