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
import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;
import com.unla.tp.services.IEspacioService;
import com.unla.tp.services.IPetitionService;

@Controller
@RequestMapping("/petitions")
public class PetitionsController {
    @Autowired
    private IPetitionService petitionService;

    @Autowired
    private IEspacioService espacioService;

    // REDIRIGE A LAS PETICIONES HECHAS
    @Secured("ROLE_ADMIN")
    @GetMapping("/made")
    public ModelAndView petitions() {

        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITIONS_LST);

        return mV;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITION_DETAILS);

        PetitionNote petitionNote = petitionService.getById(id);

        mV.addObject("petition", petitionNote);
        mV.addObject("matchedSpaces", espacioService.matchedSpaces(petitionNote.getFecha(), petitionNote.getTurno(),
                petitionNote.getCantEstudiantes()));

        return mV;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/decline/{id}")
    public ModelAndView decline(@PathVariable int id) {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITIONS_LST);

        PetitionNote petitionNote = petitionService.getById(id);

        petitionService.rechazar(petitionNote);

        return mV;
    }

    // REDIRIGE A NUEVAS NOTAS DE PEDIDO
    @Secured("ROLE_PROFESOR")
    @GetMapping("/create")
    public ModelAndView newPetition() {

        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_PETITION);
        mV.addObject("petition", new Petition());
        return mV;
    }

    @PostMapping("/create")
    public ModelAndView newNotePetition(@ModelAttribute("petition") Petition petitionModel) {

        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_PETITION);

        petitionService.insert(petitionModel);
        mV.addObject("successMessage", "Petición creada");

        return mV;
    }

}
