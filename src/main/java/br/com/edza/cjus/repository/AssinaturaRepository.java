package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Assinatura;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer>{
	
//	@Query("SELECT new  br.com.edza.cjus.model.cjus.Assinatura(\n" +
//			"id, fkDocumento, assinatura, algoritmoHashAssinatura,\n" + 
//			"cadeiaCertificadoAssinatura, codificacaoCertificadoAssinatura, dataAssinatura,\n" + 
//			"signatatioLoginIdentficador) " +
//			"FROM Assinatura c WHERE c.fkDocumento = :fkDocumento")
	@Query("SELECT n " +
            "FROM Assinatura as n " +
            "WHERE " +
         "      n.documentoid = :documentoid")
	List<Assinatura> consultarAssinatura(@Param("documentoid") Integer documentoid);
}
