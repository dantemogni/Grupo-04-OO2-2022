package com.unla.tp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.Aula;
import com.unla.tp.services.IAulaService;

@Controller
@RequestMapping("/classroom")
public class AulaController {
    @Autowired
    private IAulaService aulaService;

    @GetMapping("/list")
    public ModelAndView lstAulas() {

        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CLASSROOM_LST);

        List<Aula> aulas = aulaService.getAll();

        modelAndView.addObject("classrooms", aulas);

        return modelAndView;
    }
}
