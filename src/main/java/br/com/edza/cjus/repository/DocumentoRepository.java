package br.com.edza.cjus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{
	
//	@Query("SELECT new  br.com.edza.cjus.model.cjus.Documento(\n" +
//			"id, fkManifestacaoProcessual, idDocumento, idDocumentoVinculado,\n" + 
//			"tipoDocumentoConsultapje, dataHoraDocumento, descricaoDocumento, hashDocumento,\n" + 
//			"nivelSigiloDocumento, tipoDocumento, conteudoDocumento, mimetypeDocumento\n" + 
//			") " +
//			"FROM Documento c WHERE c.fkManifestacaoProcessual = :fkManifestacaoProcessual")
	@Query("SELECT n " +
            "FROM Documento as n " +
            "WHERE " +
         "      n.processoid = :processoid")
	List<Documento> consultarDocumento(@Param("processoid") Integer processoid);
}
