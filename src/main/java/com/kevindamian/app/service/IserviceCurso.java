package com.kevindamian.app.service;

import java.util.*;

import com.kevindamian.app.entity.Curso;

public interface IserviceCurso {

	public List<Curso> findAll();
	
	public void saveCurso(Curso curso);
	
	public List<Curso> getCursosProfesor(Long id);
	
//	public Optional<Curso> findCurProById(Long id);
	
}
