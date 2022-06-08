package com.unla.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.services.IRoleService;
import com.unla.tp.services.IUserService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping(value = { "index", "/" })
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        com.unla.tp.entities.User userEntity = userService.getByUsername(userDetails.getUsername());

        modelAndView.addObject("username", userDetails.getUsername());
        modelAndView.addObject("nombre", userEntity.getNombre());
        modelAndView.addObject("apellido", userEntity.getApellido());

        String userRole = userDetails.getAuthorities().stream().toArray()[0].toString(); // Obtiene el nombre del rol de
                                                                                         // la pos. 0
                                                                                         // del listado de roles del
                                                                                         // usuario

        modelAndView.addObject("userRole", roleService.getByNombre(userRole).toString());

        return modelAndView;
    }
}
