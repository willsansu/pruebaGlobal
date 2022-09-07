package com.prueba.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.global.entities.DatosPersonales;


public interface DatosPersonalesRepository extends CrudRepository<DatosPersonales, String> {
	
	@Query(nativeQuery = true, value = "SELECT identificacion, nombres, apellidos, edad, direccion, celular  from datos_personales"
			+ " where identificacion=:identificacion")
	List<Object[]> getByIdenti(@Param("identificacion") String identificacion);
	
	@Query(nativeQuery = true, value = "SELECT identificacion, nombres, apellidos, edad, direccion, celular  from datos_personales")
	List<Object[]> lsDatos();
	
}
