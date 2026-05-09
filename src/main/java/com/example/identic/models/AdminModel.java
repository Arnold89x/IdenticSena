package com.example.identic.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String correo;
    @Column
    private String contrasena;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "admin_rol",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<RolModel> rol;

    public AdminModel(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public AdminModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<RolModel> getRol() {
        return rol;
    }

    public void setRol(List<RolModel> rol) {
        this.rol = rol;
    }
}
