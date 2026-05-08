package com.example.identic.services;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EstudianteService extends UserDetailsService {

    EstudianteModel guardar(EstudianteRegistroDTO registroDTO);

}
