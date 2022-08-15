package com.kevindamian.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kevindamian.app.entity.Profesor;
import com.kevindamian.app.mapper.Mapper;
import com.kevindamian.app.model.Mprofesor;
import com.kevindamian.app.service.IserviceProfes;

@RestController
@RequestMapping("/api")
public class ProfesorController {
	
	@Autowired
	private IserviceProfes pro;
	
	
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesor(){
		return pro.findAll();
		
	}
	
		
	@PostMapping("/registrar")
	public ResponseEntity<Void> GuardarProfesor(@RequestBody Profesor profesor ){
		if (pro.findProfesor(profesor)== null) {
			pro.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		
	}
	
	@PostMapping("/findProfesor")
	public ResponseEntity<?> findProfesor( @RequestBody Profesor profesor  ){
		Profesor profe = pro.findProfesor(profesor);
		if (profe!=null) {
			return new ResponseEntity<>(profe, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
		
	}
	
	@PostMapping("login")
	public ResponseEntity<?> loginProfesor( @RequestBody Profesor profesor  ){
		Profesor profe= pro.checkProfesorLogin(profesor);
		if (profe!=null) {
			List<Profesor> profess = new ArrayList<>();
			profess.add(profe);
			List<Mprofesor> mpro = new ArrayList<>();
			mpro= Mapper.convertirLista(profess);
			return new ResponseEntity<>(mpro, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
		
	
	
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> ActualizarProfesor(@PathVariable(value = "id") Long id, @RequestBody Profesor profesor  ){
		Profesor prof= null;
		prof = pro.findById(id);
		if (prof != null) {
			prof.setEmail(profesor.getEmail());
			prof.setNombre(profesor.getNombre());
			pro.profesorUpdate(prof);
			return new ResponseEntity<> (prof, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PutMapping("/actualizarSQL")
	public ResponseEntity<?> ActualizarProfesorSQL(@RequestBody Profesor profesor  ){
		Profesor prof= null;
		prof = pro.findByIdSql(profesor.getId());
		if (prof != null) {
			prof.setEmail(profesor.getEmail());
			prof.setNombre(profesor.getNombre());
			pro.profesorUpdate(prof);
			return new ResponseEntity<> (prof, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	@DeleteMapping("/borrarProfe/{id}")
	public ResponseEntity<Void> deleteProfesor(@PathVariable(value="id") Long id ){
		pro.deleteProfesor(id);
		return new 	ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/borrarTodoProfe")
	public ResponseEntity<Void> deleteAllProfesor( ){
		pro.deleteAllProfesor();
		return new 	ResponseEntity<Void>(HttpStatus.OK);
	}
}
