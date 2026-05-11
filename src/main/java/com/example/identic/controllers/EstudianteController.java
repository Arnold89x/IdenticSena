package com.example.identic.controllers;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import com.example.identic.repositories.EstudianteRepository;
import com.example.identic.services.EstudianteService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/perfil")
    public String perfilEstudiante(Model model, Authentication authentication) {

        String email = authentication.getName();

        EstudianteModel estudiante = estudianteRepository.findByEmail(email);

        model.addAttribute("estudiante", estudiante);

        return "index";
    }

    @PostMapping("/perfil/actualizar")
    public String actualizarPerfil(EstudianteRegistroDTO estudianteRegistroDTO, Authentication auth) {

        String email = auth.getName();

        estudianteService.actualizarPerfil(email, estudianteRegistroDTO);

        return "redirect:/estudiante/perfil";
    }

}
