package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Documento;
import br.com.edza.cjus.model.cjus.ManifestacaoProcessual;
import br.com.edza.cjus.model.cjus.Polo;

@Repository
public interface ManifestacaoProcessualRepository extends JpaRepository<ManifestacaoProcessual, Integer>{
	
	@Query("SELECT n " +
            "FROM ManifestacaoProcessual as n " +
            "WHERE " +
         " n.statusProcessamento = 100")
	List<ManifestacaoProcessual> consultaRegistrosProcessar();
}
