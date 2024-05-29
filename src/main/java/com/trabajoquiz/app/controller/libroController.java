package com.trabajoquiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trabajoquiz.app.entity.Libro;
import com.trabajoquiz.app.repository.libroCrud;

@Controller
public class libroController {
    
    @Autowired
    private libroCrud libroRepository;
    
    @GetMapping("/mostrarLibros")  
    public String mostrarLibros(Model model) {
        List<Libro> listaLibros = libroRepository.findAll();
        model.addAttribute("listaLibros", listaLibros);
        return "mostrarLibro";
    }
    
    @GetMapping("/mostrarLibros/formLibro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "formLibro";
    }
    
    @PostMapping("/guardarLibro")
    public String guardarLibro(Libro libro) {
        libroRepository.save(libro);
        return "redirect:/mostrarLibros";
    }
    
    @GetMapping("/libro/editar/{id}")
    public String modificarKibro(@PathVariable("id") Long id, Model model) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "formLibro";
        } else {
            return "redirect:/mostrarLibros";
        }
    }
    
    @GetMapping("/libro/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
    	libroRepository.deleteById(id);
        return "redirect:/mostrarLibros";
    }
}
