package com.unla.tp.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tp.controllers.helpers.ViewRouteHelper;

import net.bytebuddy.asm.Advice.Return;

@Controller
public class PetitionsController {


    //REDIRIGE A LAS PETICIONES HECHAS
    @Secured("ROLE_ADMIN")
    @GetMapping("/manOrderNotes")
    public ModelAndView petitions(){

        ModelAndView mV = new ModelAndView(ViewRouteHelper.PETITIONS_LST);
        
        return mV;
    }

    //REDIRIGE A NUEVAS NOTAS DE PEDIDO
    @Secured("ROLE_PROFESOR")
    @GetMapping("/petitionNote")
    public ModelAndView newPetition(){

        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_PETITION);

        return mV;
    }
    
}
