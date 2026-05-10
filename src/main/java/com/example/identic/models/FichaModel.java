package com.example.identic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ficha")
public class FichaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "fichas")
    private List<AulaModel> aulaModelList = new ArrayList<>();
    @Column
    private Long codigo;
    @Column
    private int estudiantes;

    public FichaModel(Long codigo, int estudiantes) {
        this.codigo = codigo;
        this.estudiantes = estudiantes;
    }

    public FichaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AulaModel> getAulasModelList() {
        return aulaModelList;
    }

    public void setAulasModelList(List<AulaModel> aulaModelList) {
        this.aulaModelList = aulaModelList;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }
}
