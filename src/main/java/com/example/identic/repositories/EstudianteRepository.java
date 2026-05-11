package com.example.identic.repositories;

import com.example.identic.models.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {

    EstudianteModel findByEmail(String email);
    List<EstudianteModel> findByNombre(String nombre);

}