package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.AssuntoProcessual;

@Repository
public interface AssuntoProcessualRepository extends JpaRepository<AssuntoProcessual, Integer>{
	
	@Query("SELECT new  br.com.edza.cjus.model.cjus.AssuntoProcessual(\n" +
			"id, principal, codigoNacional) " +
			"FROM AssuntoProcessual c WHERE c.processoid = :processoid")
	List<AssuntoProcessual> consultaRegistrosProcessar(@Param("processoid") Integer fkDadosBasicos);
}
