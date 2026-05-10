package com.example.identic.controllers;

import com.example.identic.dto.AulaFichaDTO;
import com.example.identic.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RelacionAulaFichaController {

    @Autowired
    AulaService aulaService;

    @PostMapping("/relacion/guardar")
    public String guardarRelacion(AulaFichaDTO dto) {

        aulaService.asignarFicha(
                dto.getAulaId(),
                dto.getFichaId()
        );

        return "redirect:/admin/aulasYFichas";
    }

    @GetMapping("/relacion/eliminar/{aulaId}/{fichaId}")
    public String eliminarRelacion(@PathVariable Long aulaId, @PathVariable Long fichaId) {

        aulaService.eliminarRelacion(aulaId, fichaId);

        return "redirect:/admin/aulasYFichas";
    }
}
