package com.unla.tp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.PetitionRequest;
import com.unla.tp.services.IEspacioService;
import com.unla.tp.services.IPetitionService;
import com.unla.tp.services.IUserService;

@Controller
@RequestMapping("/petitions")
public class PetitionsController {
    @Autowired
    private IPetitionService petitionService;

    @Autowired
    private IEspacioService espacioService;

    @Autowired
    private IUserService userService;

    // REDIRIGE A LAS PETICIONES HECHAS
    @Secured("ROLE_ADMIN")
    @GetMapping("/made")
    public ModelAndView petitions() {
        // aca se ve el listado de todas las vistas
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITIONS_LST);

        mV.addObject("petitions", petitionService.getAll());

        return mV;
    }

    @Secured("ROLE_PROFESOR")
    @GetMapping("/teacher/list")
    public ModelAndView listProfesor() {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITION_PROFESOR_LST);

        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.unla.tp.entities.User userEntity = userService.getByUsername(userDetails.getUsername());

        List<PetitionNote> petitionsNote = petitionService.getAllByUserId(userEntity.getId());

        mV.addObject("petitions", petitionsNote);

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
    @GetMapping("/accept/{id}/for-space/{idSpace}")
    public ModelAndView accept(@PathVariable int id, @PathVariable int idSpace) {
        petitionService.aceptar(id, idSpace);

        return new ModelAndView("redirect:/petitions/made");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/decline/{id}")
    public ModelAndView decline(@PathVariable int id) {
        petitionService.rechazar(id);

        return new ModelAndView("redirect:/petitions/made");
    }

    // REDIRIGE A NUEVAS NOTAS DE PEDIDO
    @Secured("ROLE_PROFESOR")
    @GetMapping("/create")
    public ModelAndView newPetition() {

        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_PETITION);
        mV.addObject("petition", new PetitionRequest());
        return mV;
    }

    @PostMapping("/create")
    public ModelAndView newNotePetition(@ModelAttribute("petition") PetitionRequest petition) {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.unla.tp.entities.User userEntity = userService.getByUsername(userDetails.getUsername());

        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_PETITION);
        mV.addObject("petition", petition);

        petitionService.insert(petition, userEntity);
        mV.addObject("successMessage", "Petición creada");

        return mV;
    }

}
