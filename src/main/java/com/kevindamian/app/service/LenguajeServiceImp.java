package com.kevindamian.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevindamian.app.dao.ILenguajeDao;
import com.kevindamian.app.entity.Lenguaje;

@Service
public class LenguajeServiceImp implements IserviceLenguaje {
	@Autowired
	private ILenguajeDao ilenguajedao;

	
	
	@Override
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
		
		return (List<Lenguaje>) ilenguajedao.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		ilenguajedao.save(lenguaje);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Lenguaje findLenguajeByID(Long id) {
		return ilenguajedao.findByIdSQL(id);
	}

}
