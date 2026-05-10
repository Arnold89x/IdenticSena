package com.example.identic.controllers;

import com.example.identic.dto.AulaRegistroDTO;
import com.example.identic.models.AulaModel;
import com.example.identic.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping("/aula/nuevo")
    public String nuevaAula(Model model){
        model.addAttribute("aula",new AulaModel());
        return "formularioCrearAula";
    }

    @PostMapping("/aula/guardar")
    public String guardar(AulaRegistroDTO aulaRegistroDTO){
        aulaService.guardar(aulaRegistroDTO);
        return "redirect:/admin/aulasYFichas";
    }

    @GetMapping("/aula/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        AulaModel aulaModel = aulaService.obtenerPorId(id);
        model.addAttribute("aula",aulaModel);
        return "formularioEditarAula";
    }

    @GetMapping("/aula/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        aulaService.eliminar(id);
        return "redirect:/admin/aulasYFichas";
    }
}
