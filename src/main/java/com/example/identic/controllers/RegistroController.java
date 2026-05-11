package com.example.identic.controllers;


import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import com.example.identic.models.FichaModel;
import com.example.identic.repositories.EstudianteRepository;
import com.example.identic.services.EstudianteService;
import com.example.identic.services.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RegistroController {

    @Autowired
    private EstudianteService service;

    @Autowired
    private FichaService fichaService;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(required = false) String nombre, Model model) {

        List<EstudianteModel> estudiantes;

        if (nombre == null || nombre.isBlank()) {
            estudiantes = estudianteRepository.findAll();
        } else {
            estudiantes = estudianteRepository.findByNombre(nombre);
        }

        model.addAttribute("estudiantes", estudiantes);

        return "dashboard";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new EstudianteModel());
        model.addAttribute("fichas", fichaService.listarFichas());
        return "formularioCrear";
    }

    @PostMapping("/guardar")
    public String guardar(EstudianteRegistroDTO estudianteRegistroDTO) {
        service.guardar(estudianteRegistroDTO);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        EstudianteModel estudianteModel = service.obtenerPorId(id);
        model.addAttribute("estudiante", estudianteModel);

        model.addAttribute("fichas", fichaService.listarFichas());

        return "formularioEditar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/admin/dashboard";
    }
}