package com.kevindamian.app.service;

import java.util.List;
import java.util.Optional;

import com.kevindamian.app.entity.Profesor;

public interface IserviceProfes {
	public List<Profesor> findAll();
	
	public void save(Profesor profesor);
	
	public Profesor findProfesor (Profesor profesor);
	
	public Profesor checkProfesorLogin(Profesor profesor);
	
	public void deleteProfesor(Profesor profesor);
	
	public Profesor profesorUpdate(Profesor profesor);
	
	public Optional<Profesor> findProfesorById(Long id);
	
	public void deleteProfesor (Long id);
	public void deleteAllProfesor();
	
	public Profesor findById (Long id);
	
	public Profesor findByIdSql(Long id);
}
