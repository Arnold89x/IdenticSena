package com.example.identic.controllers;


import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import com.example.identic.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RegistroController {

    @Autowired
    private EstudianteService service;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("estudiantes", service.listarEstudiantes());
        return "dashboard";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("estudiante", new EstudianteModel());
        return "formularioCrear";
    }

    @PostMapping("/guardar")
    public String guardar(EstudianteRegistroDTO estudianteRegistroDTO){
        service.guardar(estudianteRegistroDTO);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){

        EstudianteModel estudianteModel = service.obtenerPorId(id);
        model.addAttribute("estudiante", estudianteModel);

        return "formularioEditar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        service.eliminar(id);
        return "redirect:/admin/dashboard";
    }
}