package com.kevindamian.app.service;

import java.util.List;

import com.kevindamian.app.entity.Lenguaje;

public interface IserviceLenguaje {
	
	public List<Lenguaje> findAll();
	
	public void saveLenguaje(Lenguaje lenguaje);
	
	public Lenguaje findLenguajeByID(Long id);

}
