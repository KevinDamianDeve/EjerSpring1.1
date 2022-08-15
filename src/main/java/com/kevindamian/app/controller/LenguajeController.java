package com.kevindamian.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevindamian.app.entity.Lenguaje;
import com.kevindamian.app.service.IserviceLenguaje;

@RestController
@RequestMapping("/apiL")
public class LenguajeController {

	@Autowired
	private IserviceLenguaje ilenguajeService;
	
	@GetMapping("/lenguajes")
	public ResponseEntity<?> listaLenguajes(){
		List<Lenguaje> listal = ilenguajeService.findAll();
		
		if (listal!=null) {
			if (listal.size()!=0) {
				return new ResponseEntity<>(listal, HttpStatus.OK);
			}
			
		}
		return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@PostMapping("/crear_lenguaje")
	public ResponseEntity<?> agregarLenguaje(@RequestBody Lenguaje lenguaje ){
		ilenguajeService.saveLenguaje(lenguaje);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	
	
}
