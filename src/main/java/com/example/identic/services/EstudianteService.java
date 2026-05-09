package com.example.identic.services;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EstudianteService extends UserDetailsService {

    EstudianteModel guardar(EstudianteRegistroDTO registroDTO);

    List<EstudianteModel> listarEstudiantes();

    EstudianteModel obtenerPorId(Long id);

    void eliminar(Long id);

}
