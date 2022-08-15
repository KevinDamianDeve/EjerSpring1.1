package com.kevindamian.app.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_curso;

	private String nombre;

	@Column(name = "profesor_id")
	private Long profesorId;
	
	public Curso() {
		
	}

	// @Column(name="id_profesor")
	// private Long profesorId;

	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn( name="id_profesor")
	// @JsonProperty(access = Access.WRITE_ONLY)
	// private Profes prof;

	public Long getId_curso() {
		return id_curso;
	}

	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public Long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}



	private static final long serialVersionUID = 1L;

}
