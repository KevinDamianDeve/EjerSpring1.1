package com.kevindamian.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevindamian.app.entity.Lenguaje;
import com.kevindamian.app.entity.Profesor;
import com.kevindamian.app.model.ProfesorLenguaje;
import com.kevindamian.app.service.IserviceLenguaje;
import com.kevindamian.app.service.IserviceProfes;

@RestController
@RequestMapping("/apiPL")
public class ProfesorLenguajeRestController {

	
	@Autowired
	public IserviceLenguaje iserLenguaje;
	
	@Autowired
	public IserviceProfes iserProfes;
	
	
	@PostMapping("/lenguajes_profes")
	public ResponseEntity<?> listaLenguajeProfes(@RequestBody Profesor profesor){
		Profesor prof = iserProfes.findById(profesor.getId());
		if (prof != null) {
			Collection<Lenguaje> listaL= prof.getLenguaje();
			if (listaL!=null) {
				return new ResponseEntity<>(listaL, HttpStatus.OK);
			}
			
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/save_lenguaje_profesor")
	public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorlenguaje ){
		Profesor prof = iserProfes.findById(profesorlenguaje.getProfesor().getId());
		if (prof!=null) {
			Lenguaje leng = iserLenguaje.findLenguajeByID(profesorlenguaje.getLenguaje().getId());
			prof.addLenguaje(leng);
			iserProfes.save(prof);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
}
