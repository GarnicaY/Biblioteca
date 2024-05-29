package com.trabajoquiz.app.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="administradores")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "administrador")
    private List<Solicitud> solicitudes;

    public Admin() {
        super();
    }

    public Admin(Long id, String nombre, String email) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
