// ObjetoController.java

package com.ejemplo.controller;

import com.ejemplo.model.Objeto;
import com.ejemplo.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("objetos", objetoService.findAll());
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("objeto", new Objeto());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Objeto objeto) {
        objetoService.save(objeto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Objeto objeto = objetoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de objeto inválido: " + id));
        model.addAttribute("objeto", objeto);
        return "form";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        objetoService.deleteById(id);
        return "redirect:/";
    }
}
