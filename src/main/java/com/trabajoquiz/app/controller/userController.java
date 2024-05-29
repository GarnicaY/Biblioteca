package com.trabajoquiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trabajoquiz.app.entity.User;
import com.trabajoquiz.app.repository.userCrud;

@Controller
public class userController {
    
    @Autowired
    private userCrud userRepository;
    
    @GetMapping("/mostrarUsuarios")  
    public String mostrarUsuarios(Model model) {
        List<User> listarUsuarios = userRepository.findAll();
        model.addAttribute("listarUsuarios", listarUsuarios);
        return "mostrarUsers";
    }
    
    @GetMapping("/mostrarUsers/formUsers")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new User());
        return "formUsers";
    }
    
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(User usuario) {
        userRepository.save(usuario);
        return "redirect:/mostrarUsuarios";
    }
    
    @GetMapping("/user/editar/{id}")
    public String modificarUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            model.addAttribute("usuario", user);
            return "formUsers";
        } else {
            return "redirect:/mostrarUsuarios";
        }
    }
    
    @GetMapping("/usuario/eliminar/{id}")
    public String eliminarUser(@PathVariable("id") Long id) {
    	userRepository.deleteById(id);
        return "redirect:/mostrarUsuarios";
    }

}
