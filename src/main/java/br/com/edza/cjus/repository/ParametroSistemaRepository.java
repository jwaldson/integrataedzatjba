package br.com.edza.cjus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.ParametroSistema;

@Repository
public interface ParametroSistemaRepository extends JpaRepository<ParametroSistema, Integer> {

	@Query("SELECT n " +
            "FROM ParametroSistema as n " +
            "WHERE " +
         "      n.nome = :nome")
	public ParametroSistema consultarParametroPeloNome(String nome);
	
}