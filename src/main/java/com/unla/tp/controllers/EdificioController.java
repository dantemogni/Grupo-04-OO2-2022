package com.unla.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.Edificio;
import com.unla.tp.models.EdificioRequest;
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        edificioService.remove(id);
        return new ModelAndView("redirect:/building/list");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.BUILDING_EDIT);

        Edificio edificio = edificioService.getById(id);

        EdificioRequest edificioRequest = EdificioRequest.builder()
                .id(edificio.getId())
                .edificio(edificio.getEdificio())
                .build();

        modelAndView.addObject("building", edificioRequest);
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update")
    public ModelAndView actualizar(@ModelAttribute("building") EdificioRequest edificio) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.BUILDING_EDIT);

        modelAndView.addObject("building", edificio);

        edificioService.update(edificio);

        modelAndView.addObject("successMessage", "Edificio actualizado con éxito");

        return modelAndView;
    }
}
