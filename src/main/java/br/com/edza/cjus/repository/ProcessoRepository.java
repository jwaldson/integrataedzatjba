package br.com.edza.cjus.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.edza.cjus.model.cjus.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer>{
	@Query("SELECT new br.com.edza.cjus.model.cjus.Processo(c.id, c.id_manifestante, c.senha_manifestante, c.classe_processual, c.codigo_localidade,\n" + 
			"					c.competencia, c.modalidade_vinculacao_processo, c.prioridade, c.valor_causa, c.assistencia_judiciaria, c.nivel_sigilo,\n" + 
			"					c.data_ajuizamento, c.outro_parametro, c.polo, c.parte_nome, c.parte_sexo, c.parte_nome_genitor, c.parte_nome_genitora,\n" + 
			"					c.parte_data_nascimento, c.parte_data_obito, c.parte_numero_documento_principal, c.parte_tipo_pessoa, c.parte_cidade_natural,\n" + 
			"					c.parte_estado_natural, c.parte_nacionalidade, c.parte_codigo_documento, c.parte_emissor_documento, c.parte_tipo_documento,\n" + 
			"					c.parte_nome_detentora, c.parte_outro_nome, c.endereco_cep, c.endereco_logradouro, c.endereco_numero, c.endereco_complemento,\n" + 
			"					c.endereco_bairro, c.endereco_cidade, c.endereco_estado, c.endereco_pais, c.repres_processual_intimacao, c.repres_processual_nome,\n" + 
			"					c.repres_processual_inscricao, c.repres_processual_numero_documento_principal, c.repres_processual_tipo_representante, c.assunto_processual_principal,\n" + 
			"					c.assunto_processual_codigo_nacional, c.assunto_processual_codigo_assunto, c.assunto_processual_codigo_pai_acional, c.assunto_processual_descricao,\n" + 
			"					c.id_documento, c.id_documento_vinculado, c.tipo_documento_consultapje, c.data_hora_documento, c.descricao_documento, c.hash_documento,\n" + 
			"					c.nivel_sigilo_documento, c.tipo_documento, c.conteudo_documento, c.mimetype_documento, c.assinatura, c.algoritmo_hash_assinatura,\n" + 
			"					c.cadeia_certificado_assinatura, c.codificacao_certificado_assinatura, c.dataassinatura, c.signatariologin, c.retorno_sucesso, \n" + 
			"					c.retorno_mensagem, c.retorno_protocolo_recebimento, c.retorno_data_operacao, c.retorno_recibo, c.sai_conteudo_retornado, \n" + 
			"					c.sai_data_atualizacao_registro, c.sai_erro_sistema) FROM Processo c WHERE c.entra_status_processamento = '00'")
		List<Processo> consultaRegistrosProcessar();
	
}
