package com.example.identic.models;


import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rol;

    public RolModel(Long id, String rol) {
        super();
        this.id = id;
        this.rol = rol;
    }

    public RolModel(String rol){
        super();
        this.rol = rol;
    }

    public RolModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
