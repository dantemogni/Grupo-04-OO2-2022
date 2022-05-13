package com.unla.tp.controllers;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.User;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping(value = { "/index", "/" })
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("nombre", user.getNombre());
        modelAndView.addObject("apellido", user.getApellido());

        return modelAndView;
    }
}
