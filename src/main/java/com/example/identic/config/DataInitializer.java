package com.example.identic.config;

import com.example.identic.models.AdminModel;
import com.example.identic.models.RolModel;
import com.example.identic.repositories.AdminRepository;
import com.example.identic.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        RolModel rolAdmin = rolRepository.findByRol("ROLE_ADMIN");

        if (rolAdmin == null) {
            rolAdmin = new RolModel();
            rolAdmin.setRol("ROLE_ADMIN");
            rolRepository.save(rolAdmin);
        }

        if (adminRepository.findByCorreo("admin@demo.com") == null) {

            AdminModel admin = new AdminModel("admin@demo.com", passwordEncoder.encode("12345678"));
            admin.setRol(List.of(rolAdmin));
            adminRepository.save(admin);
        }
    }

}