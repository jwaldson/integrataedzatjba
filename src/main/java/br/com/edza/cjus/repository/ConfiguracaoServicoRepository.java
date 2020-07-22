package br.com.edza.cjus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Advogado;
import br.com.edza.cjus.model.cjus.ConfiguracaoServico;

@Repository
public interface ConfiguracaoServicoRepository extends JpaRepository<ConfiguracaoServico, Integer>{
	
	@Query("SELECT new  br.com.edza.cjus.model.cjus.ConfiguracaoServico(\n" +
			"id, idManifestante, senhaManifestante)\n" + 
			"FROM ConfiguracaoServico c WHERE c.id = :id")
	ConfiguracaoServico consultarconfiguracaoSistema(@Param("id") Integer id);
	
	
	
}
