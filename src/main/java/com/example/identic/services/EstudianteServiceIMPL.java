package com.example.identic.services;

import com.example.identic.dto.EstudianteRegistroDTO;
import com.example.identic.models.EstudianteModel;
import com.example.identic.models.RolModel;
import com.example.identic.repositories.EstudianteRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceIMPL implements EstudianteService, UserDetailsService {

    private EstudianteRepository estudianteRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public EstudianteServiceIMPL(
            EstudianteRepository estudianteRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.estudianteRepository = estudianteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public EstudianteModel guardar(EstudianteRegistroDTO estudianteRegistroDTO) {

        EstudianteModel estudianteModel = new EstudianteModel(

                Arrays.asList(new RolModel("ROL_ESTUDIANTE")),

                estudianteRegistroDTO.getTipoDocumento(),
                estudianteRegistroDTO.getNumeroDocumento(),
                estudianteRegistroDTO.getNombre(),
                estudianteRegistroDTO.getApellido(),
                estudianteRegistroDTO.getEmail(),

                passwordEncoder.encode(
                        estudianteRegistroDTO.getContrasena()
                ),

                estudianteRegistroDTO.getTelefono(),
                estudianteRegistroDTO.getEdad()
        );
        return estudianteRepository.save(estudianteModel);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        EstudianteModel estudiante = estudianteRepository.findByEmail(email);

        if(estudiante == null){
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(
                estudiante.getEmail(),
                estudiante.getContrasena(),
                mapearAutoridadesRoles(estudiante.getRol())
        );
    }

    private Collection<SimpleGrantedAuthority> mapearAutoridadesRoles(Collection<RolModel> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
    }
}