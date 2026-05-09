package com.example.identic.repositories;

import com.example.identic.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolModel, Long> {
    RolModel findByRol(String rol);
}
