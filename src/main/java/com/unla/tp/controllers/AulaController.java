package com.unla.tp.controllers;

import java.util.List;

import org.hibernate.Hibernate;
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
import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Laboratorio;
import com.unla.tp.entities.Tradicional;
import com.unla.tp.models.aula.LaboratorioRequest;
import com.unla.tp.models.aula.TradicionalRequest;
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

    @GetMapping("/list/for-building/{id}")
    public ModelAndView lstAulasForBuilding(@PathVariable("id") int id) {

        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CLASSROOM_LST_BLDNG);

        List<Aula> aulas = aulaService.findAllByEdificioId(id);

        modelAndView.addObject("nombreEdificio", aulas.get(0).getEdificio().getEdificio());
        modelAndView.addObject("classrooms", aulas);

        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/modify/{id}")
    public ModelAndView modifyClassroom(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CLASSROOM_EDIT);

        Aula aula = aulaService.getById(id);

        if (Hibernate.unproxy(aula) instanceof Laboratorio) {
            Laboratorio l = (Laboratorio) Hibernate.unproxy(aula);
            LaboratorioRequest aulaRequest = LaboratorioRequest.builder()
                    .id(id)
                    .cantPc(l.getCantPc())
                    .cantSillas(l.getCantSillas())
                    .numero(l.getNumero())
                    .build();

            modelAndView.addObject("classroom", aulaRequest);

        } else {
            Tradicional t = (Tradicional) Hibernate.unproxy(aula);
            TradicionalRequest aulaRequest = TradicionalRequest.builder()
                    .id(id)
                    .cantBancos(t.getCantBancos())
                    .numero(t.getNumero())
                    .pizarron(t.getPizarron())
                    .tieneProyector(t.isTieneProyector())
                    .build();

            modelAndView.addObject("classroom", aulaRequest);

        }

        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/trad/update")
    public ModelAndView actualizarTrad(@ModelAttribute("classroom") TradicionalRequest classroom) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CLASSROOM_EDIT);

        modelAndView.addObject("classroom", classroom);
        aulaService.update(classroom);
        modelAndView.addObject("successMessage", "Aula actualizada con éxito");

        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/lab/update")
    public ModelAndView actualizarLab(@ModelAttribute("classroom") LaboratorioRequest classroom) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CLASSROOM_EDIT);

        modelAndView.addObject("classroom", classroom);
        aulaService.update(classroom);
        modelAndView.addObject("successMessage", "Aula actualizada con éxito");

        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        aulaService.remove(id);
        return new ModelAndView("redirect:/classroom/list");
    }
}
