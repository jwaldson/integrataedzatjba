package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Advogado;
import br.com.edza.cjus.model.cjus.Pessoa;

@Repository
public interface AdvogadoRepository extends JpaRepository<Advogado, Integer>{
	
//	@Query("SELECT new  br.com.edza.cjus.model.cjus.Advogado(\n" +
//			"id, intimacao, nome, inscricao, numeroDocumentoPrincipal,\n" + 
//			"tipoRepresentante, cep, logradouro, numero, complemento, bairro,\n" + 
//			"cidade, estado, pais)\n" + 
//			"FROM Pessoa c WHERE c.pessoaid = :pessoaid")
	@Query("SELECT n " +
            "FROM Advogado as n " +
            "WHERE " +
         "      n.pessoaid_adm = :pessoaid_adm")
	List<Advogado> consultarAdvogado(@Param("pessoaid_adm") Integer id);
	
	
	
}
