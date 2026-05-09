package com.example.identic.controllers;

import com.example.identic.models.EstudianteModel;
import com.example.identic.repositories.EstudianteRepository;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;
    @GetMapping("/perfil")
    public String perfilEstudiante(Model model, Authentication authentication) {

        String email = authentication.getName();

        EstudianteModel estudiante = estudianteRepository.findByEmail(email);

        model.addAttribute("estudiante", estudiante);

        return "index";
    }

}
