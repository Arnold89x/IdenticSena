package com.example.identic.services;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.AdminModel;
import com.example.identic.models.EstudianteModel;
import com.example.identic.models.RolModel;
import com.example.identic.repositories.AdminRepository;
import com.example.identic.repositories.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceIMPL implements EstudianteService, UserDetailsService {

    private EstudianteRepository estudianteRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public EstudianteServiceIMPL(EstudianteRepository estudianteRepository, BCryptPasswordEncoder passwordEncoder) {
        this.estudianteRepository = estudianteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    AdminRepository adminRepository;

    @Override
    public EstudianteModel guardar(EstudianteRegistroDTO estudianteRegistroDTO) {

        EstudianteModel estudiante;

        if (estudianteRegistroDTO.getId() != 0) {
            estudiante = estudianteRepository.findById(estudianteRegistroDTO.getId()).orElse(new EstudianteModel());
        } else {
            estudiante = new EstudianteModel();
        }
        List<RolModel> roles = new ArrayList<>();
        roles.add(new RolModel("ROLE_ESTUDIANTE"));
        estudiante.setRol(roles);
        estudiante.setTipoDocumento(estudianteRegistroDTO.getTipoDocumento());
        estudiante.setNumeroDocumento(estudianteRegistroDTO.getNumeroDocumento());
        estudiante.setNombre(estudianteRegistroDTO.getNombre());
        estudiante.setApellido(estudianteRegistroDTO.getApellido());
        estudiante.setEmail(estudianteRegistroDTO.getEmail());
        estudiante.setTelefono(estudianteRegistroDTO.getTelefono());
        estudiante.setEdad(estudianteRegistroDTO.getEdad());
        if (estudianteRegistroDTO.getContrasena() != null) {
            estudiante.setContrasena(passwordEncoder.encode(estudianteRegistroDTO.getContrasena()));
        }

        return estudianteRepository.save(estudiante);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AdminModel admin = adminRepository.findByCorreo(email);
        EstudianteModel estudiante = estudianteRepository.findByEmail(email);

        if (estudiante == null && admin == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        if (estudiante != null) {
            return new User(estudiante.getEmail(), estudiante.getContrasena(), mapearAutoridadesRoles(estudiante.getRol()));
        }else{
            return new User(admin.getCorreo(),admin.getContrasena(),mapearAutoridadesRoles(admin.getRol()));
        }
    }

    private Collection<SimpleGrantedAuthority> mapearAutoridadesRoles(Collection<RolModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
    }

    @Override
    public List<EstudianteModel> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteModel obtenerPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }

}