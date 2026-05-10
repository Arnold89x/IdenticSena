package com.example.identic.controllers;

import com.example.identic.dto.FichaRegistroDTO;
import com.example.identic.models.FichaModel;
import com.example.identic.services.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @GetMapping("/ficha/nuevo")
    public String nuevaFicha(Model model){
        model.addAttribute("ficha",new FichaModel());
        return "formularioCrearFicha";
    }

    @PostMapping("/ficha/guardar")
    public String guardar(FichaRegistroDTO fichaRegistroDTO){
        fichaService.guardar(fichaRegistroDTO);
        return "redirect:/admin/aulasYFichas";
    }

    @GetMapping("/ficha/editar/{id}")
    public String editar(@PathVariable Long id,Model model){
        FichaModel fichaModel = fichaService.obtenerPorId(id);
        model.addAttribute("ficha",fichaModel);
        return "formularioEditarFicha";
    }

    @GetMapping("/ficha/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
       fichaService.eliminar(id);
       return "redirect:/admin/aulasYFichas";
    }

}
