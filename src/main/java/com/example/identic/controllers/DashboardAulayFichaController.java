package com.example.identic.controllers;

import com.example.identic.services.AulaService;
import com.example.identic.services.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardAulayFichaController {

    @Autowired
    AulaService aulaService;

    @Autowired
    FichaService fichaService;

    @GetMapping("/aulasYFichas")
    public String dashboardAulaYFicha(Model model){
        model.addAttribute("aulas",aulaService.listarAulas());
        model.addAttribute("fichas",fichaService.listarFichas());

        return "aulaYFichaDashboard";
    }

}
