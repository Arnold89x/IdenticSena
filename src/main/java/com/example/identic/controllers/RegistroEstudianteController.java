package com.example.identic.controllers;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.services.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroEstudianteController {

    private EstudianteService estudianteService;

    public RegistroEstudianteController(EstudianteService estudianteService) {
        super();
        this.estudianteService = estudianteService;
    }

    @ModelAttribute("estudiante")
    public EstudianteRegistroDTO retornarNuevoEstudianteRegistroDTO(){
        return new EstudianteRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeEstudiante(@ModelAttribute("estudiante") EstudianteRegistroDTO registroDTO){
        estudianteService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

}
