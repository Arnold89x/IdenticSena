package com.example.identic.repositories;

import com.example.identic.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {

    AdminModel findByCorreo(String correo);
}