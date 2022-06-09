package com.unla.tp.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;
import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.User;
import com.unla.tp.models.UserRequest;
import com.unla.tp.models.validator.UserRequestValidator;
import com.unla.tp.services.IUserService;
import com.unla.tp.utils.UserPDFExporter;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView(ViewRouteHelper.USER_LOGIN);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/register")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);
        modelAndView.addObject("userSignUpRequest", new UserRequest());
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid @ModelAttribute("userSignUpRequest") UserRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);

        modelAndView.addObject("userSignUpRequest", user);

        UserRequestValidator uv = new UserRequestValidator(userService);
        uv.validate(user, bindingResult);

        // checks empty value errors
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        userService.createUser(user);
        modelAndView.addObject("successMessage", "Registro exitoso");

        return modelAndView;
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/index";
    }

    @GetMapping("/userLst")
    public ModelAndView lstUsuarios() {

        ModelAndView mV = new ModelAndView(ViewRouteHelper.USERS_LST);
        mV.addObject("users", userService.getAll());
        mV.addObject("user", new UserRequest());

        return mV;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.remove(id);
        return "redirect:/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_EDIT);

        User user = userService.findById(id);

        UserRequest userRequest = UserRequest.builder()
                .idUser(user.getId())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .email(user.getEmail())
                .tipoDocumento(user.getTipoDocumento())
                .nroDocumento(user.getNroDocumento())
                .username(user.getUsername())
                .password(user.getPassword())
                .roleId(user.getRole().getId())
                .build();

        modelAndView.addObject("user", userRequest);
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update")
    public ModelAndView actualizar(@Valid @ModelAttribute("user") UserRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_EDIT);

        modelAndView.addObject("user", user);

        UserRequestValidator uv = new UserRequestValidator(userService);
        uv.validateUpdate(user, bindingResult);

        // checks empty value errors
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        userService.updateUser(user);

        modelAndView.addObject("successMessage", "Usuario actualizado con éxito");

        return modelAndView;
    }

    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.getAll();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);

    }

}
