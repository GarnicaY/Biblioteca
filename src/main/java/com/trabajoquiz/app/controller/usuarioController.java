package com.trabajoquiz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usuarioController {

    @GetMapping("/usuarios")
    public String showUsuario() {
        return "usuarios";
    }
}