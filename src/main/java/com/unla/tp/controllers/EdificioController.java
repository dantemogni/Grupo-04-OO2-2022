package com.unla.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.services.IEdificioService;

@Controller
@RequestMapping("/building")
public class EdificioController {
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/list")
    public ModelAndView lstBuildings() {

        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.BUILDING_LST);

        modelAndView.addObject("buildings", edificioService.getAll());

        return modelAndView;
    }
}
