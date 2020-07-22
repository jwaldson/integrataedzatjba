package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
//	@Query("SELECT new  br.com.edza.cjus.model.cjus.Pessoa(\n" +
//			"id, nome, sexo, dataNascimento,\n" + 
//			"numeroDocumentoPrincipal, tipoPessoa, cidadeNatural, estadoNatural,\n" + 
//			"nacionalidade, cep, logradouro, numero, complemento, bairro,\n" + 
//			"cidade, estado, pais, codigoDocumento, emissorDocumento,\n" + 
//			"tipoDocumento, nomeDetentora)\n" + 
//			"FROM Pessoa c WHERE c.poloid = :poloid")
	
	@Query("SELECT n " +
            "FROM Pessoa as n " +
            "WHERE " +
         "      n.poloid = :poloid")
	List<Pessoa> consultarPessoa(@Param("poloid") Integer poloid);
	
}
