package com.unla.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.services.IUserService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = { "index", "/" })
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        com.unla.tp.entities.User userEntity = userService.getByUsername(userDetails.getUsername());

        modelAndView.addObject("username", userDetails.getUsername());
        modelAndView.addObject("nombre", userEntity.getNombre());
        modelAndView.addObject("apellido", userEntity.getApellido());

        String userRole = userDetails.getAuthorities().stream().toArray()[0].toString();

        if (userRole.equals("ROLE_ADMIN")) {
            userRole = "Administrador";
        } else if (userRole.equals("ROLE_AUDITOR")) {
            userRole = "Auditor";
        } else if (userRole.equals("ROLE_PROFESOR")) {
            userRole = "Profesor";
        } else if (userRole.equals("ROLE_ASISTENTE")) {
            userRole = "Asistente";
        } else if (userRole.equals("ROLE_ALUMNO")) {
            userRole = "Alumno";
        }

        modelAndView.addObject("userRole", userRole);

        return modelAndView;
    }
}
