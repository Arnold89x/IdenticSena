package com.example.identic.dto;

import jakarta.persistence.Column;

public class AulaRegistroDTO {

    private Long id;
    private String nombre;
    private int capacidad;
    private String sede;
    private String piso;

    public AulaRegistroDTO(Long id, String nombre, int capacidad, String sede, String piso) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.piso = piso;
    }

    public AulaRegistroDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
