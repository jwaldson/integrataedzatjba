package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Polo;

@Repository
public interface PoloRepository extends JpaRepository<Polo, Integer>{
	
	@Query("SELECT n " +
            "FROM Polo as n " +
            "WHERE " +
         "      n.processoid = :processoid")
	List<Polo> consultaRegistrosProcessar(@Param("processoid") Integer fkDadosBasicos);
}
