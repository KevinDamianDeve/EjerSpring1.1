package com.kevindamian.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevindamian.app.dao.IcursoDao;
import com.kevindamian.app.entity.Curso;

@Service
public class CursoServiceImp implements IserviceCurso {

	@Autowired
	private IcursoDao icursodao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Curso> findAll() {		
		return (List<Curso>) icursodao.findAll();
	}

	@Override	
	public void saveCurso(Curso curso) {
		icursodao.save(curso);
	}

	@Override
	public List<Curso> getCursosProfesor(Long id) {
		return (List<Curso> ) icursodao.findByProfesorId(id);
	}

	/*@Override
	public Optional<Curso> findCurProById(Long id) {
		return (Optional<Curso>) icursodao.findById(id);
	}*/


}
	
