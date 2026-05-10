package com.example.identic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="aula")
public class AulaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "aula_ficha",
            joinColumns = @JoinColumn(name = "aula_id"),
            inverseJoinColumns = @JoinColumn(name = "ficha_id")
    )
    private List<FichaModel> fichas = new ArrayList<>();

    @Column
    private String nombre;
    @Column
    private int capacidad;
    @Column
    private String sede;
    @Column
    private String piso;

    public AulaModel(String nombre, int capacidad, String sede, String piso) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.piso = piso;
    }

    public AulaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FichaModel> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaModel> fichas) {
        this.fichas = fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
}
