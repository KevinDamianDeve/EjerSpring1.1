package com.kevindamian.app.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(length = 60, unique = true)
	private String email;
	
	private String password;
	
	@Column (length = 200)
	private String foto;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="profesor_id", referencedColumnName = "id")
	private List<Curso> curso= new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "profesores_lenguajes",
			joinColumns = @JoinColumn(name="profesor_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="lenguaje_id", referencedColumnName = "id"))
	private Set<Lenguaje> lenguaje = new HashSet<>();	
	
	
		
	
	public Set<Lenguaje> getLenguaje() {
		return lenguaje;
	}



	public void setLenguaje(Set<Lenguaje> lenguaje) {
		this.lenguaje = lenguaje;
	}



	@PrePersist
	public void prePersist() {
		create_at= new Date();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	

	public void addLenguaje(Lenguaje leng) {
		this.lenguaje.add(leng);
	}
	
	
	
	
	
	
	
}
