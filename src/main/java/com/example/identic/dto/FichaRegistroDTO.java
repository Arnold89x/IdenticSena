package com.example.identic.dto;

public class FichaRegistroDTO {

    private Long id;
    private Long codigo;
    private int estudiantes;

    public FichaRegistroDTO(Long id, Long codigo, int estudiantes) {
        this.id = id;
        this.codigo = codigo;
        this.estudiantes = estudiantes;
    }

    public FichaRegistroDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
