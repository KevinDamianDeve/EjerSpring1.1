package com.kevindamian.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kevindamian.app.entity.Profesor;
import com.kevindamian.app.model.Mprofesor;

@Component("mapper")
public class Mapper {
	public static List<Mprofesor> convertirLista (List<Profesor> profes){
		List<Mprofesor> mprof = new ArrayList<>();
		for(Profesor profe: profes) {
			mprof.add(new Mprofesor(profe));
		}
		return mprof;
		
	}

}
