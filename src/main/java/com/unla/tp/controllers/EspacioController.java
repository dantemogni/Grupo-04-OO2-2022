package com.unla.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.services.IEspacioService;

@Controller
@RequestMapping("/space")
public class EspacioController {
    @Autowired
    private IEspacioService espacioService;

    @GetMapping("/list")
    public ModelAndView lstEspacios() {

        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.SPACE_LST);
        // try {
        // espacioService.inicializarEspacios(3, 2022);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        modelAndView.addObject("spaces", espacioService.getAll());

        return modelAndView;
    }

}
