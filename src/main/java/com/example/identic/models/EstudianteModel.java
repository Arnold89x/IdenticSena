package com.example.identic.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "estudiante",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class EstudianteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "estudiante_rol",
            joinColumns = @JoinColumn(name = "estudiante_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
    )
    private Collection<RolModel> rol;
    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private FichaModel ficha;
    @Column
    private String tipoDocumento;
    @Column
    private String numeroDocumento;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String contrasena;
    @Column
    private String telefono;
    @Column
    private int edad;

    public EstudianteModel(Collection<RolModel> rol,String tipoDocumento, String numeroDocumento, String nombre, String apellido, String email, String contrasena, String telefono, int edad) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.edad = edad;
    }

    public EstudianteModel() {
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<RolModel> getRol() {
        return rol;
    }

    public void setRol(Collection<RolModel> rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public FichaModel getFicha() {
        return ficha;
    }

    public void setFicha(FichaModel ficha) {
        this.ficha = ficha;
    }
}
