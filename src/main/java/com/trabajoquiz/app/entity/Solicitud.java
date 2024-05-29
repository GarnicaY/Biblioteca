package com.trabajoquiz.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="solicitudes")
public class Solicitud {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreUsuario;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libroSolicitado;

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Admin administrador;

    private String estado;  // "APROBADA", "RECHAZADA", "PENDIENTE"

    public Solicitud() {
        super();
        this.estado = "PENDIENTE";
    }

	public Solicitud(Long id, String nombreUsuario, Libro libroSolicitado, Admin administrador, String estado) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.libroSolicitado = libroSolicitado;
		this.administrador = administrador;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Libro getLibroSolicitado() {
		return libroSolicitado;
	}

	public void setLibroSolicitado(Libro libroSolicitado) {
		this.libroSolicitado = libroSolicitado;
	}

	public Admin getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Admin administrador) {
		this.administrador = administrador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
