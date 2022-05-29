package com.unla.tp.controllers;

import javax.validation.Valid;

import com.unla.tp.controllers.helpers.ViewRouteHelper;
import com.unla.tp.entities.User;
import com.unla.tp.models.UserSignUpRequest;
import com.unla.tp.models.validator.UserSignUpRequestValidator;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

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
        modelAndView.addObject("userSignUpRequest", new UserSignUpRequest());
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid UserSignUpRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.USER_REGISTRATION);

        modelAndView.addObject("userSignUpRequest", user);

        UserSignUpRequestValidator uv = new UserSignUpRequestValidator(userService);
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
    public ModelAndView lstUsuarios(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.USERS_LST);
        mV.addObject("users", userService.getAll());
        //System.err.println(userService.getAll());
        mV.addObject("user", new UserSignUpRequest());
        return mV;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        //System.err.println(userService.findById(id).getApellido());
        userService.remove(id);
        return "redirect:/index";
    }
    
    @GetMapping("/modify/{id}")
    public String modifyUser(@PathVariable("id") int id, ModelMap mp){
        mp.put("user", userService.findById(id));
        return "user/editUser";
    }

    @PostMapping("/update")
        public String actualizar(@Valid User usuario, BindingResult bindingResult, ModelMap mp){
            User user = userService.findById(usuario.getId());
            user.setNombre(usuario.getNombre());
            user.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
            user.setEmail(usuario.getEmail());
            user.setApellido(usuario.getApellido());
            user.setTipoDocumento(usuario.getTipoDocumento());
            user.setUsername(usuario.getUsername());
            user.setNroDocumento(usuario.getNroDocumento());
            userService.save(user);
    
        return "redirect:/index";
}
    
}
