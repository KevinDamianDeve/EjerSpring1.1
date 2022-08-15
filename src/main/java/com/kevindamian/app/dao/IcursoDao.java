package com.kevindamian.app.dao;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevindamian.app.entity.Curso;
//import com.kevindamian.app.entity.Profes;
@Repository
public interface IcursoDao extends CrudRepository<Curso, Long> {
	
//	public List<Curso> findByProfesor_id(Long id);
	
	//public Optional<Curso> findById(Long id);
	
//	public List<Curso> findById(Long id);
	
	
	public List<Curso>   findByProfesorId(Long id);
}