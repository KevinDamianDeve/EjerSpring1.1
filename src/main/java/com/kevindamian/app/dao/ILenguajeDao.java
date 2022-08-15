package com.kevindamian.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevindamian.app.entity.Lenguaje;
@Repository
public interface ILenguajeDao extends CrudRepository<Lenguaje, Long> {

	@Query(value="select * from lenguaje l where l.id=?1",  nativeQuery = true)
	public Lenguaje findByIdSQL(Long id);
}
