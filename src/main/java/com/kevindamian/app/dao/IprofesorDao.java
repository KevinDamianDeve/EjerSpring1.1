package com.kevindamian.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevindamian.app.entity.Profesor;

@Repository
public interface IprofesorDao extends CrudRepository<Profesor, Long> {
	
	public Profesor findByEmail(String email);
	
	public Profesor findByEmailAndPassword(String email, String password);
	
	public Optional<Profesor> findById(Long id);
	
	@Query(value="select * from profesor p where p.id=?1" , nativeQuery = true)
	public Profesor findByIdSQL(Long id);

}
