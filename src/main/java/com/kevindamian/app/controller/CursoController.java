package com.kevindamian.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevindamian.app.entity.Curso;
import com.kevindamian.app.entity.Profesor;
import com.kevindamian.app.service.IserviceCurso;

@RestController
@RequestMapping("/apiC")
public class CursoController {
	
	//-------- INYECTAR
	@Autowired
	private IserviceCurso serviceCurso;
	
	
	
	//--------LISTAR CURSOS
	@GetMapping("/cursos")
	public ResponseEntity<?> ListaCursos(){
		List<Curso> listCursos = serviceCurso.findAll();
		if (listCursos!=null) {
			if (listCursos.size()!=0) {
				return new ResponseEntity<>(listCursos, HttpStatus.OK); 
			}else {
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
			}
			
		}else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	//-----------CREAR CURSOS
	
	@PostMapping("/crear_curso")
	public ResponseEntity<?> AgregarCurso(@RequestBody Curso curso ){
		serviceCurso.saveCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//-------CURSOS DEL PROFESOR
	
	@PostMapping("/cursos_profesor")
	public ResponseEntity<?> VerCursosProfesor(@RequestBody Profesor pro ){
		List<Curso> listCursos = serviceCurso.getCursosProfesor(pro.getId());
		if (listCursos!=null) {
			if (listCursos.size()!=0) {
				return new ResponseEntity<>(listCursos, HttpStatus.OK); 
			}else {
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
			}
			
		}else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
